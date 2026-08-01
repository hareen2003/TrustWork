package COHNDSE252_069;

import utils.DisplayFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Trust Network Manager using Graph
 * Author: Member 3 (Pramuditha)
 */
public class TrustNetworkManager {
    private Graph trustGraph;
    private Map<String, List<VouchRecord>> vouchRecords;
    private int vouchCounter;
    
    public TrustNetworkManager() {
        this.trustGraph = new Graph();
        this.vouchRecords = new HashMap<>();
        this.vouchCounter = 0;
    }
    
    public boolean addEmployer(String employerId, String employerName) {
        boolean success = trustGraph.addVertex(employerId);
        if (success) {
            DisplayFormatter.printSuccess("Employer " + employerId + " added to network");
        }
        return success;
    }
    
    public boolean addWorkerToNetwork(String workerId) {
        boolean success = trustGraph.addVertex(workerId);
        if (success) {
            DisplayFormatter.printSuccess("Worker " + workerId + " added to network");
        }
        return success;
    }
    
    public boolean createVouch(String workerId, String employerId,
                             String employerName, String comment, double rating) {
        // Validation
        if (rating < 1.0 || rating > 5.0) {
            DisplayFormatter.printError("Rating must be between 1 and 5");
            return false;
        }
        
        // Add vertices if needed
        if (!trustGraph.getAllVertices().contains(workerId)) {
            addWorkerToNetwork(workerId);
        }
        
        if (!trustGraph.getAllVertices().contains(employerId)) {
            addEmployer(employerId, employerName);
        }
        
        vouchCounter++;
        String vouchId = "VOUCH-" + vouchCounter;
        
        VouchRecord record = new VouchRecord(vouchId, workerId, employerId, employerName, comment, rating);
        
        if (!vouchRecords.containsKey(workerId)) {
            vouchRecords.put(workerId, new ArrayList<>());
        }
        
        vouchRecords.get(workerId).add(record);
        
        // Add edge to graph
        if (trustGraph.getNeighbors(workerId).contains(employerId)) {
            // Edge already exists, just count
        } else {
            trustGraph.addEdge(workerId, employerId, 1);
        }
        
        DisplayFormatter.printSuccess("Vouch from " + employerName + " to " + workerId + " created");
        return true;
    }
    
    public List<VouchRecord> getWorkerVouches(String workerId) {
        return vouchRecords.getOrDefault(workerId, new ArrayList<>());
    }
    
    public int getVouchCount(String workerId) {
        if (!trustGraph.getAllVertices().contains(workerId)) {
            return 0;
        }
        
        return trustGraph.getDegree(workerId);
    }
    
    public double getAverageRating(String workerId) {
        List<VouchRecord> vouches = getWorkerVouches(workerId);
        
        if (vouches.isEmpty()) {
            return 0.0;
        }
        
        double totalRating = 0;
        for (VouchRecord v : vouches) {
            totalRating += v.getRating();
        }
        
        return totalRating / vouches.size();
    }
    
    public List<String> getTrustNetwork(String workerId) {
        if (!trustGraph.getAllVertices().contains(workerId)) {
            return new ArrayList<>();
        }
        
        return trustGraph.getNeighbors(workerId);
    }
    
    public boolean isWorkersConnected(String worker1, String worker2) {
        return trustGraph.isConnected(worker1, worker2);
    }
    
    public List<String> getConnectionPath(String worker1, String worker2) {
        return trustGraph.getPath(worker1, worker2);
    }
    
    public void displayTrustNetwork(String workerId) {
        if (!trustGraph.getAllVertices().contains(workerId)) {
            DisplayFormatter.printInfo("Worker not found in network");
            return;
        }
        
        DisplayFormatter.printHeader("Trust Network for " + workerId);
        
        List<VouchRecord> vouches = getWorkerVouches(workerId);
        
        if (vouches.isEmpty()) {
            DisplayFormatter.printInfo("No vouches yet");
            return;
        }
        
        System.out.println("Total Vouches: " + getVouchCount(workerId));
        System.out.println("Average Rating: " + String.format("%.2f", getAverageRating(workerId)) + "/5.0\n");
        
        System.out.println("Employers who vouched:");
        System.out.println("-".repeat(60));
        
        for (VouchRecord vouch : vouches) {
            System.out.println("\n" + vouch.getEmployerName() + " (" + vouch.getEmployerId() + ")");
            System.out.println("  Rating: " + String.format("%.1f", vouch.getRating()) + "/5.0");
            System.out.println("  Comment: " + vouch.getComment());
        }
    }
    
    public void displayVouchDetails(String workerId) {
        List<VouchRecord> vouches = getWorkerVouches(workerId);
        
        if (vouches.isEmpty()) {
            DisplayFormatter.printInfo("No vouches found");
            return;
        }
        
        DisplayFormatter.printHeader("Vouch Details for " + workerId);
        
        for (int i = 0; i < vouches.size(); i++) {
            VouchRecord vouch = vouches.get(i);
            System.out.println("\n" + (i+1) + ". Vouch from " + vouch.getEmployerName());
            System.out.println("   ID: " + vouch.getVouchId());
            System.out.println("   Rating: " + String.format("%.1f", vouch.getRating()) + "/5.0");
            System.out.println("   Comment: " + vouch.getComment());
            System.out.println("   Date: " + vouch.getDate());
            System.out.println("-".repeat(60));
        }
    }
    
    public List<String> getAllWorkersInNetwork() {
        List<String> workers = new ArrayList<>();
        for (String vertex : trustGraph.getAllVertices()) {
            if (vouchRecords.containsKey(vertex)) {
                workers.add(vertex);
            }
        }
        return workers;
    }
    
    public void displayTopWorkers(int limit) {
        List<String> workers = getAllWorkersInNetwork();
        
        if (workers.isEmpty()) {
            DisplayFormatter.printInfo("No workers with vouches yet");
            return;
        }
        
        DisplayFormatter.printHeader("Top Rated Workers");
        
        // Simple sort by vouches
        workers.sort((w1, w2) -> {
            int v1 = getVouchCount(w1);
            int v2 = getVouchCount(w2);
            double r1 = getAverageRating(w1);
            double r2 = getAverageRating(w2);
            
            if (v1 != v2) return Integer.compare(v2, v1);
            return Double.compare(r2, r1);
        });
        
        for (int i = 0; i < Math.min(limit, workers.size()); i++) {
            String worker = workers.get(i);
            System.out.println((i+1) + ". " + worker);
            System.out.println("   Vouches: " + getVouchCount(worker));
            System.out.println("   Rating: " + String.format("%.2f", getAverageRating(worker)) + "/5.0");
        }
    }
}

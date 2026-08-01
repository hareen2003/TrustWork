package member1;

import utils.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Worker Profile Manager using AVL Tree
 * Author: Member 1 (Senethma)
 */
public class WorkerProfileManager {
    private AVLTree<String, WorkerProfile> profilesTree;
    
    public WorkerProfileManager() {
        this.profilesTree = new AVLTree<>();
    }
    
    /**
     * Add new worker profile
     */
    public boolean addWorker(String workerId, String name, String email,
                            String contact, List<String> skills, String location) {
        // Validation
        if (!Validator.validateWorkerId(workerId)) {
            DisplayFormatter.printError("Invalid worker ID format");
            return false;
        }
        
        if (!Validator.validateName(name)) {
            DisplayFormatter.printError("Invalid name format");
            return false;
        }
        
        if (!Validator.validateEmail(email)) {
            DisplayFormatter.printError("Invalid email format");
            return false;
        }
        
        if (skills == null || skills.isEmpty()) {
            DisplayFormatter.printError("At least one skill is required");
            return false;
        }
        
        if (profilesTree.search(workerId) != null) {
            DisplayFormatter.printError("Worker " + workerId + " already exists");
            return false;
        }
        
        WorkerProfile profile = new WorkerProfile(workerId, name, email, contact, skills, location);
        boolean success = profilesTree.insert(workerId, profile);
        
        if (success) {
            DisplayFormatter.printSuccess("Worker " + workerId + " added successfully");
        }
        
        return success;
    }
    
    /**
     * Search for worker by ID
     */
    public WorkerProfile searchWorker(String workerId) {
        return profilesTree.search(workerId);
    }
    
    /**
     * Delete worker
     */
    public boolean deleteWorker(String workerId) {
        boolean success = profilesTree.delete(workerId);
        
        if (success) {
            DisplayFormatter.printSuccess("Worker " + workerId + " deleted");
        } else {
            DisplayFormatter.printError("Worker " + workerId + " not found");
        }
        
        return success;
    }
    
    /**
     * Get all workers
     */
    public List<WorkerProfile> getAllWorkers() {
        List<WorkerProfile> workers = new ArrayList<>();
        List<String> keys = profilesTree.getAllKeys();
        for (String key : keys) {
            workers.add(profilesTree.search(key));
        }
        return workers;
    }
    
    /**
     * Search by skill
     */
    public List<WorkerProfile> searchBySkill(String skill) {
        List<WorkerProfile> results = new ArrayList<>();
        for (WorkerProfile worker : getAllWorkers()) {
            for (String s : worker.getSkills()) {
                if (s.equalsIgnoreCase(skill)) {
                    results.add(worker);
                    break;
                }
            }
        }
        return results;
    }
    
    /**
     * Search by location
     */
    public List<WorkerProfile> searchByLocation(String location) {
        List<WorkerProfile> results = new ArrayList<>();
        for (WorkerProfile worker : getAllWorkers()) {
            if (worker.getLocation().equalsIgnoreCase(location)) {
                results.add(worker);
            }
        }
        return results;
    }
    
    /**
     * Update vouch count
     */
    public boolean updateVouchCount(String workerId, int increment) {
        WorkerProfile profile = searchWorker(workerId);
        if (profile != null) {
            profile.updateVouchCount(increment);
            return true;
        }
        return false;
    }
    
    /**
     * Display worker information
     */
    public void displayWorker(WorkerProfile worker) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Worker ID: " + worker.getWorkerId());
        System.out.println("Name: " + worker.getName());
        System.out.println("Email: " + worker.getEmail());
        System.out.println("Contact: " + worker.getContact());
        System.out.println("Skills: " + String.join(", ", worker.getSkills()));
        System.out.println("Location: " + worker.getLocation());
        System.out.println("Vouches: " + worker.getVouchCount());
        System.out.println("Rating: " + String.format("%.1f", worker.getRating()) + "/5.0");
        System.out.println("Status: " + (worker.isActive() ? "Active" : "Inactive"));
        System.out.println("Created: " + worker.getCreatedDate());
        System.out.println("=".repeat(60) + "\n");
    }
    
    /**
     * Display all workers
     */
    public void displayAllWorkers() {
        List<WorkerProfile> workers = getAllWorkers();
        
        if (workers.isEmpty()) {
            DisplayFormatter.printInfo("No workers registered yet");
            return;
        }
        
        DisplayFormatter.printHeader("All Registered Workers");
        
        // Table header
        List<String> headers = new ArrayList<>();
        headers.add("ID");
        headers.add("Name");
        headers.add("Skills");
        headers.add("Location");
        headers.add("Vouches");
        
        List<Integer> widths = new ArrayList<>();
        widths.add(10); widths.add(15); widths.add(20); widths.add(12); widths.add(8);
        
        DisplayFormatter.printTableRow(headers, widths);
        DisplayFormatter.printSeparator(65);
        
        // Table rows
        for (WorkerProfile worker : workers) {
            String skillsStr = String.join(", ", worker.getSkills().subList(0,
                Math.min(2, worker.getSkills().size())));
            if (worker.getSkills().size() > 2) {
                skillsStr += "+" + (worker.getSkills().size() - 2);
            }
            
            List<String> row = new ArrayList<>();
            row.add(worker.getWorkerId());
            row.add(worker.getName());
            row.add(skillsStr);
            row.add(worker.getLocation());
            row.add(String.valueOf(worker.getVouchCount()));
            
            DisplayFormatter.printTableRow(row, widths);
        }
    }
    
    /**
     * Get statistics
     */
    public String getStatistics() {
        List<WorkerProfile> workers = getAllWorkers();
        
        if (workers.isEmpty()) {
            return "Total: 0, Active: 0, Inactive: 0";
        }
        
        int active = 0;
        int totalVouches = 0;
        double totalRating = 0;
        
        for (WorkerProfile w : workers) {
            if (w.isActive()) active++;
            totalVouches += w.getVouchCount();
            totalRating += w.getRating();
        }
        
        double avgVouches = totalVouches / (double) workers.size();
        double avgRating = totalRating / (double) workers.size();
        
        return String.format("Total: %d, Active: %d, Inactive: %d, Avg Vouches: %.2f, Avg Rating: %.2f",
            workers.size(), active, workers.size() - active, avgVouches, avgRating);
    }
    
    public int getSize() {
        return profilesTree.getSize();
    }
}

package member2;

import utils.DisplayFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Job History Manager using Doubly Linked List
 * Author: Member 2 (Perera)
 */
public class JobHistoryManager {
    private Map<String, DoublyLinkedList<JobEntry>> workerJobHistories;
    private int jobCounter;
    
    public JobHistoryManager() {
        this.workerJobHistories = new HashMap<>();
        this.jobCounter = 0;
    }
    
    public boolean addJob(String workerId, String employerName, String jobTitle,
                         String description, String startDate, String endDate,
                         boolean isCurrent) {
        jobCounter++;
        String jobId = "JOB-" + workerId + "-" + jobCounter;
        
        JobEntry jobEntry = new JobEntry(jobId, workerId, employerName,
                                         jobTitle, description, startDate, endDate, isCurrent);
        
        if (!workerJobHistories.containsKey(workerId)) {
            workerJobHistories.put(workerId, new DoublyLinkedList<>());
        }
        
        workerJobHistories.get(workerId).insertAtHead(jobEntry);
        
        DisplayFormatter.printSuccess("Job added: " + jobEntry);
        return true;
    }
    
    public List<JobEntry> getWorkerJobHistory(String workerId) {
        if (!workerJobHistories.containsKey(workerId)) {
            return new ArrayList<>();
        }
        
        return workerJobHistories.get(workerId).forwardTraversal();
    }
    
    public List<JobEntry> getWorkerJobHistoryReversed(String workerId) {
        if (!workerJobHistories.containsKey(workerId)) {
            return new ArrayList<>();
        }
        
        return workerJobHistories.get(workerId).backwardTraversal();
    }
    
    public long getTotalExperienceMonths(String workerId) {
        List<JobEntry> history = getWorkerJobHistory(workerId);
        long total = 0;
        
        for (JobEntry job : history) {
            total += job.getDurationMonths();
        }
        
        return total;
    }
    
    public int getJobCount(String workerId) {
        if (!workerJobHistories.containsKey(workerId)) {
            return 0;
        }
        
        return workerJobHistories.get(workerId).getSize();
    }
    
    public void displayWorkerHistory(String workerId, boolean reverse) {
        if (!workerJobHistories.containsKey(workerId)) {
            DisplayFormatter.printInfo("No job history found");
            return;
        }
        
        List<JobEntry> history = reverse ? getWorkerJobHistoryReversed(workerId) :
                                          getWorkerJobHistory(workerId);
        
        if (history.isEmpty()) {
            DisplayFormatter.printInfo("No jobs registered");
            return;
        }
        
        String direction = reverse ? "Oldest to Newest" : "Newest to Oldest";
        DisplayFormatter.printHeader("Job History for " + workerId + " (" + direction + ")");
        
        int i = 1;
        for (JobEntry job : history) {
            System.out.println("\n" + i + ". " + job.getJobTitle());
            System.out.println("   Employer: " + job.getEmployerName());
            System.out.println("   Period: " + job.getStartDate() + " to " + job.getEndDate());
            System.out.println("   Duration: " + job.getDurationMonths() + " months");
            System.out.println("   Description: " + job.getDescription());
            System.out.println("   Status: " + (job.isCurrent() ? "Current" : "Completed"));
            System.out.println("-".repeat(60));
            i++;
        }
    }
    
    public List<JobEntry> getAllJobs() {
        List<JobEntry> allJobs = new ArrayList<>();
        for (DoublyLinkedList<JobEntry> jobs : workerJobHistories.values()) {
            allJobs.addAll(jobs.forwardTraversal());
        }
        return allJobs;
    }
}

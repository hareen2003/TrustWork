package COHNDSE252_055;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import utils.DateTimeHelper;

/**
 * Job history entry data class
 * Author: Member 2 (Perera)
 */
public class JobEntry {
    private String jobId;
    private String workerId;
    private String employerName;
    private String jobTitle;
    private String description;
    private String startDate;
    private String endDate;
    private boolean isCurrent;
    private long durationMonths;
    private String addedDate;
    
    public JobEntry(String jobId, String workerId, String employerName,
                   String jobTitle, String description, String startDate,
                   String endDate, boolean isCurrent) {
        this.jobId = jobId;
        this.workerId = workerId;
        this.employerName = employerName;
        this.jobTitle = jobTitle;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isCurrent = isCurrent;
        this.durationMonths = calculateDuration();
        this.addedDate = DateTimeHelper.getCurrentDateTime();
    }
    
    private long calculateDuration() {
        if (isCurrent) return 0;
        
        try {
            LocalDate start = LocalDate.parse(startDate);
            LocalDate end = LocalDate.parse(endDate);
            return ChronoUnit.MONTHS.between(start, end);
        } catch (Exception e) {
            return 0;
        }
    }
    
    // Getters
    public String getJobId() { return jobId; }
    public String getWorkerId() { return workerId; }
    public String getEmployerName() { return employerName; }
    public String getJobTitle() { return jobTitle; }
    public String getDescription() { return description; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public boolean isCurrent() { return isCurrent; }
    public long getDurationMonths() { return durationMonths; }
    public String getAddedDate() { return addedDate; }
    
    @Override
    public String toString() {
        return jobTitle + " at " + employerName + " (" + startDate + " to " + endDate + ")";
    }
}

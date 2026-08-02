package member3;

import utils.DateTimeHelper;

/**
 * Vouch/Recommendation Record
 * Author: Member 3 (Pramuditha)
 */
public class VouchRecord {
    private String vouchId;
    private String workerId;
    private String employerId;
    private String employerName;
    private String comment;
    private double rating;
    private String date;
    
    public VouchRecord(String vouchId, String workerId, String employerId,
                      String employerName, String comment, double rating) {
        this.vouchId = vouchId;
        this.workerId = workerId;
        this.employerId = employerId;
        this.employerName = employerName;
        this.comment = comment;
        this.rating = rating;
        this.date = DateTimeHelper.getCurrentDateTime();
    }
    
    // Getters
    public String getVouchId() { return vouchId; }
    public String getWorkerId() { return workerId; }
    public String getEmployerId() { return employerId; }
    public String getEmployerName() { return employerName; }
    public String getComment() { return comment; }
    public double getRating() { return rating; }
    public String getDate() { return date; }
    
    @Override
    public String toString() {
        return "Vouch from " + employerName + " to " + workerId + 
               " (Rating: " + String.format("%.1f", rating) + "/5.0)";
    }
}

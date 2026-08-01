package member1;

import utils.DateTimeHelper;
import java.util.ArrayList;
import java.util.List;

/**
 * Worker profile data class
 * Author: Member 1 (Senethma)
 */
public class WorkerProfile {
    private String workerId;
    private String name;
    private String email;
    private String contact;
    private List<String> skills;
    private String location;
    private String createdDate;
    private int vouchCount;
    private double rating;
    private boolean isActive;
    
    /**
     * Constructor
     */
    public WorkerProfile(String workerId, String name, String email, 
                        String contact, List<String> skills, String location) {
        this.workerId = workerId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.skills = new ArrayList<>(skills);
        this.location = location;
        this.createdDate = DateTimeHelper.getCurrentDateTime();
        this.vouchCount = 0;
        this.rating = 0.0;
        this.isActive = true;
    }
    
    // Getters and Setters
    public String getWorkerId() { return workerId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getContact() { return contact; }
    public List<String> getSkills() { return skills; }
    public String getLocation() { return location; }
    public String getCreatedDate() { return createdDate; }
    public int getVouchCount() { return vouchCount; }
    public double getRating() { return rating; }
    public boolean isActive() { return isActive; }
    
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setContact(String contact) { this.contact = contact; }
    public void setLocation(String location) { this.location = location; }
    public void setRating(double rating) { 
        if (rating >= 0.0 && rating <= 5.0) {
            this.rating = rating;
        }
    }
    
    public void updateVouchCount(int increment) {
        this.vouchCount += increment;
        if (this.vouchCount < 0) {
            this.vouchCount = 0;
        }
    }
    
    public void deactivate() { this.isActive = false; }
    public void activate() { this.isActive = true; }
    
    @Override
    public String toString() {
        return "WorkerProfile{" +
                "workerId='" + workerId + '\'' +
                ", name='" + name + '\'' +
                ", skills=" + skills +
                ", location='" + location + '\'' +
                '}';
    }
}

import member1.*;
import member2.*;
import member3.*;
import utils.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * TrustWork - Main Application
 * Skill Verification & Trust Network for Informal Sector Workers
 */
public class TrustWorkApplication {
    
    private WorkerProfileManager profileManager;
    private JobHistoryManager jobManager;
    private TrustNetworkManager trustManager;
    private Scanner scanner;
    
    public TrustWorkApplication() {
        this.profileManager = new WorkerProfileManager();
        this.jobManager = new JobHistoryManager();
        this.trustManager = new TrustNetworkManager();
        this.scanner = new Scanner(System.in);
    }
    
    public void run() {
        DisplayFormatter.printHeader("Welcome to TrustWork");
        System.out.println("Skill Verification & Trust Network for Informal Sector Workers\n");
        
        boolean running = true;
        
        while (running) {
            showMainMenu();
            String choice = scanner.nextLine().trim();
            
            switch(choice) {
                case "1":
                    workerProfileMenu();
                    break;
                case "2":
                    jobHistoryMenu();
                    break;
                case "3":
                    trustNetworkMenu();
                    break;
                case "4":
                    viewStatistics();
                    break;
                case "5":
                    running = false;
                    shutdown();
                    break;
                default:
                    DisplayFormatter.printError("Invalid option");
            }
        }
    }
    
    private void showMainMenu() {
        DisplayFormatter.printHeader("TrustWork - Main Menu");
        System.out.println("1. Worker Profile Management");
        System.out.println("2. Job History Management");
        System.out.println("3. Trust Network Management");
        System.out.println("4. View System Statistics");
        System.out.println("5. Exit");
        System.out.print("\nSelect an option (1-5): ");
    }
    
    private void workerProfileMenu() {
        boolean subMenu = true;
        
        while (subMenu) {
            DisplayFormatter.printSubheader("Worker Profile Management");
            System.out.println("1. Add New Worker");
            System.out.println("2. Search Worker by ID");
            System.out.println("3. View All Workers");
            System.out.println("4. Back to Main Menu");
            System.out.print("\nSelect an option (1-4): ");
            
            String choice = scanner.nextLine().trim();
            
            switch(choice) {
                case "1":
                    addWorker();
                    break;
                case "2":
                    searchWorker();
                    break;
                case "3":
                    profileManager.displayAllWorkers();
                    break;
                case "4":
                    subMenu = false;
                    break;
                default:
                    DisplayFormatter.printError("Invalid option");
            }
        }
    }
    
    private void addWorker() {
        System.out.println("\n--- Add New Worker ---");
        
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine().trim();
        
        System.out.print("Enter Full Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();
        
        System.out.print("Enter Contact Number: ");
        String contact = scanner.nextLine().trim();
        
        System.out.print("Enter Location: ");
        String location = scanner.nextLine().trim();
        
        System.out.print("Enter Skills (comma-separated): ");
        String skillsInput = scanner.nextLine().trim();
        List<String> skills = new ArrayList<>();
        for (String skill : skillsInput.split(",")) {
            skills.add(skill.trim());
        }
        
        profileManager.addWorker(workerId, name, email, contact, skills, location);
    }
    
    private void searchWorker() {
        System.out.print("Enter Worker ID to search: ");
        String workerId = scanner.nextLine().trim();
        
        WorkerProfile worker = profileManager.searchWorker(workerId);
        
        if (worker != null) {
            profileManager.displayWorker(worker);
        } else {
            DisplayFormatter.printError("Worker " + workerId + " not found");
        }
    }
    
    private void jobHistoryMenu() {
        boolean subMenu = true;
        
        while (subMenu) {
            DisplayFormatter.printSubheader("Job History Management");
            System.out.println("1. Add Job Entry");
            System.out.println("2. View Worker Job History");
            System.out.println("3. Get Total Experience");
            System.out.println("4. Back to Main Menu");
            System.out.print("\nSelect an option (1-4): ");
            
            String choice = scanner.nextLine().trim();
            
            switch(choice) {
                case "1":
                    addJob();
                    break;
                case "2":
                    viewJobHistory();
                    break;
                case "3":
                    getExperience();
                    break;
                case "4":
                    subMenu = false;
                    break;
                default:
                    DisplayFormatter.printError("Invalid option");
            }
        }
    }
    
    private void addJob() {
        System.out.println("\n--- Add Job Entry ---");
        
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine().trim();
        
        if (profileManager.searchWorker(workerId) == null) {
            DisplayFormatter.printError("Worker not found");
            return;
        }
        
        System.out.print("Enter Employer/Client Name: ");
        String employer = scanner.nextLine().trim();
        
        System.out.print("Enter Job Title: ");
        String jobTitle = scanner.nextLine().trim();
        
        System.out.print("Enter Job Description: ");
        String description = scanner.nextLine().trim();
        
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine().trim();
        
        System.out.print("Enter End Date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine().trim();
        
        System.out.print("Is this current job? (yes/no): ");
        boolean isCurrent = scanner.nextLine().trim().equalsIgnoreCase("yes");
        
        jobManager.addJob(workerId, employer, jobTitle, description, startDate, endDate, isCurrent);
    }
    
    private void viewJobHistory() {
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine().trim();
        
        System.out.print("Show from oldest to newest? (yes/no): ");
        boolean reverse = scanner.nextLine().trim().equalsIgnoreCase("yes");
        
        jobManager.displayWorkerHistory(workerId, reverse);
    }
    
    private void getExperience() {
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine().trim();
        
        long months = jobManager.getTotalExperienceMonths(workerId);
        long years = months / 12;
        long remainingMonths = months % 12;
        
        DisplayFormatter.printInfo("Total experience: " + years + " years and " + remainingMonths + " months");
    }
    
    private void trustNetworkMenu() {
        boolean subMenu = true;
        
        while (subMenu) {
            DisplayFormatter.printSubheader("Trust Network Management");
            System.out.println("1. Add Employer");
            System.out.println("2. Create Vouch");
            System.out.println("3. View Worker Trust Network");
            System.out.println("4. View Top Workers");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nSelect an option (1-5): ");
            
            String choice = scanner.nextLine().trim();
            
            switch(choice) {
                case "1":
                    addEmployer();
                    break;
                case "2":
                    createVouch();
                    break;
                case "3":
                    viewTrustNetwork();
                    break;
                case "4":
                    trustManager.displayTopWorkers(10);
                    break;
                case "5":
                    subMenu = false;
                    break;
                default:
                    DisplayFormatter.printError("Invalid option");
            }
        }
    }
    
    private void addEmployer() {
        System.out.println("\n--- Add Employer ---");
        
        System.out.print("Enter Employer ID: ");
        String employerId = scanner.nextLine().trim();
        
        System.out.print("Enter Employer Name: ");
        String employerName = scanner.nextLine().trim();
        
        trustManager.addEmployer(employerId, employerName);
    }
    
    private void createVouch() {
        System.out.println("\n--- Create Vouch ---");
        
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine().trim();
        
        System.out.print("Enter Employer ID: ");
        String employerId = scanner.nextLine().trim();
        
        System.out.print("Enter Employer Name: ");
        String employerName = scanner.nextLine().trim();
        
        System.out.print("Enter Recommendation Comment: ");
        String comment = scanner.nextLine().trim();
        
        try {
            System.out.print("Enter Rating (1-5): ");
            double rating = Double.parseDouble(scanner.nextLine().trim());
            trustManager.createVouch(workerId, employerId, employerName, comment, rating);
        } catch (NumberFormatException e) {
            DisplayFormatter.printError("Invalid rating");
        }
    }
    
    private void viewTrustNetwork() {
        System.out.print("Enter Worker ID: ");
        String workerId = scanner.nextLine().trim();
        
        trustManager.displayTrustNetwork(workerId);
    }
    
    private void viewStatistics() {
        DisplayFormatter.printHeader("System Statistics");
        System.out.println("\n=== Worker Statistics ===");
        System.out.println(profileManager.getStatistics());
        System.out.println("\n=== Job Statistics ===");
        System.out.println("Total Job Entries: " + jobManager.getAllJobs().size());
        System.out.println("\n=== Trust Network Statistics ===");
        System.out.println("Network Vertices: " + trustManager.getAllWorkersInNetwork().size());
    }
    
    private void shutdown() {
        System.out.println("\nThank you for using TrustWork!");
        scanner.close();
    }
    
    public static void main(String[] args) {
        TrustWorkApplication app = new TrustWorkApplication();
        app.run();
    }
}

package utils;

/**
 * Validator utility class for input validation
 */
public class Validator {
    
    /**
     * Validate worker ID format
     */
    public static boolean validateWorkerId(String workerId) {
        return workerId != null && workerId.trim().length() > 0 && workerId.length() <= 20;
    }
    
    /**
     * Validate worker name
     */
    public static boolean validateName(String name) {
        return name != null && name.trim().length() > 0 && name.length() <= 100;
    }
    
    /**
     * Basic email validation
     */
    public static boolean validateEmail(String email) {
        return email != null && email.contains("@") && email.contains(".") && email.length() > 5;
    }
    
    /**
     * Validate skill description
     */
    public static boolean validateSkill(String skill) {
        return skill != null && skill.trim().length() > 0 && skill.length() <= 200;
    }
    
    /**
     * Validate employer name
     */
    public static boolean validateEmployerName(String name) {
        return name != null && name.trim().length() > 0 && name.length() <= 100;
    }
    
    /**
     * Validate date format (YYYY-MM-DD)
     */
    public static boolean validateDate(String date) {
        if (date == null) return false;
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }
    
    /**
     * Validate rating (1-5)
     */
    public static boolean validateRating(double rating) {
        return rating >= 1.0 && rating <= 5.0;
    }
}

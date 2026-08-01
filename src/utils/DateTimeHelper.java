package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Handle date and time operations
 */
public class DateTimeHelper {
    
    private static final DateTimeFormatter dateTimeFormatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    private static final DateTimeFormatter dateFormatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    /**
     * Get current datetime as string
     */
    public static String getCurrentDateTime() {
        return LocalDateTime.now().format(dateTimeFormatter);
    }
    
    /**
     * Get current date as string
     */
    public static String getCurrentDate() {
        return LocalDateTime.now().format(dateFormatter);
    }
    
    /**
     * Format datetime string
     */
    public static String formatDateTime(String dateTimeString) {
        if (dateTimeString == null) return "";
        return dateTimeString.length() >= 16 ? dateTimeString.substring(0, 16) : dateTimeString;
    }
}

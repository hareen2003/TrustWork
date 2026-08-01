package utils;

import java.util.List;

/**
 * Format output for console display
 */
public class DisplayFormatter {
    
    /**
     * Print formatted header
     */
    public static void printHeader(String title) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("  " + centerString(title, 56));
        System.out.println("=".repeat(60) + "\n");
    }
    
    /**
     * Print formatted subheader
     */
    public static void printSubheader(String title) {
        System.out.println("\n--- " + title + " ---");
    }
    
    /**
     * Print success message
     */
    public static void printSuccess(String message) {
        System.out.println("✓ " + message);
    }
    
    /**
     * Print error message
     */
    public static void printError(String message) {
        System.out.println("✗ " + message);
    }
    
    /**
     * Print info message
     */
    public static void printInfo(String message) {
        System.out.println("ℹ " + message);
    }
    
    /**
     * Print table row
     */
    public static void printTableRow(List<String> columns, List<Integer> widths) {
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < columns.size(); i++) {
            String col = columns.get(i);
            int width = widths.get(i);
            row.append(String.format("%-" + width + "s", col));
        }
        System.out.println(row.toString());
    }
    
    /**
     * Print line separator
     */
    public static void printSeparator(int width) {
        System.out.println("-".repeat(width));
    }
    
    /**
     * Center string within width
     */
    private static String centerString(String str, int width) {
        if (str.length() >= width) return str;
        int padding = (width - str.length()) / 2;
        return " ".repeat(padding) + str;
    }
}

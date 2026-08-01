package utils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Handle file I/O operations for data persistence
 */
public class FileManager {
    
    /**
     * Save data to file (simple text format)
     */
    public static boolean saveData(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
            return true;
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Load data from file
     */
    public static String loadData(String filename) {
        StringBuilder data = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
            return data.toString();
        } catch (FileNotFoundException e) {
            return "";
        } catch (IOException e) {
            System.out.println("Error loading data: " + e.getMessage());
            return "";
        }
    }
}

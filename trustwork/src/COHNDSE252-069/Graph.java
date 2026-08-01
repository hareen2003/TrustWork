package COHNDSE252_069;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Graph Implementation for Trust Network
 * Author: Member 3 (Pramuditha)
 * Undirected weighted graph for managing trust relationships
 */
public class Graph {
    
    private class EdgeData {
        int weight;
        int vouchCount;
        
        EdgeData(int weight) {
            this.weight = weight;
            this.vouchCount = weight;
        }
    }
    
    private Map<String, Map<String, EdgeData>> adjacencyList;
    private Set<String> vertices;
    private int edgeCount;
    
    public Graph() {
        this.adjacencyList = new HashMap<>();
        this.vertices = new HashSet<>();
        this.edgeCount = 0;
    }
    
    public boolean addVertex(String vertex) {
        if (vertices.contains(vertex)) {
            return false;
        }
        
        adjacencyList.put(vertex, new HashMap<>());
        vertices.add(vertex);
        return true;
    }
    
    public boolean addEdge(String source, String destination, int weight) {
        if (!vertices.contains(source)) {
            addVertex(source);
        }
        if (!vertices.contains(destination)) {
            addVertex(destination);
        }
        
        if (adjacencyList.get(source).containsKey(destination)) {
            return false;
        }
        
        adjacencyList.get(source).put(destination, new EdgeData(weight));
        adjacencyList.get(destination).put(source, new EdgeData(weight));
        
        edgeCount++;
        return true;
    }
    
    public boolean isConnected(String source, String destination) {
        if (!vertices.contains(source) || !vertices.contains(destination)) {
            return false;
        }
        
        if (source.equals(destination)) {
            return true;
        }
        
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            if (current.equals(destination)) {
                return true;
            }
            
            for (String neighbor : adjacencyList.get(current).keySet()) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        return false;
    }
    
    public List<String> getPath(String source, String destination) {
        if (!vertices.contains(source) || !vertices.contains(destination)) {
            return null;
        }
        
        if (source.equals(destination)) {
            List<String> path = new ArrayList<>();
            path.add(source);
            return path;
        }
        
        Set<String> visited = new HashSet<>();
        Map<String, String> parent = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(source);
        visited.add(source);
        
        while (!queue.isEmpty()) {
            String current = queue.poll();
            
            for (String neighbor : adjacencyList.get(current).keySet()) {
                if (neighbor.equals(destination)) {
                    parent.put(destination, current);
                    
                    List<String> path = new ArrayList<>();
                    String node = destination;
                    while (node != null) {
                        path.add(0, node);
                        node = parent.get(node);
                    }
                    return path;
                }
                
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        
        return null;
    }
    
    public List<String> getNeighbors(String vertex) {
        if (!vertices.contains(vertex)) {
            return new ArrayList<>();
        }
        
        return new ArrayList<>(adjacencyList.get(vertex).keySet());
    }
    
    public int getDegree(String vertex) {
        if (!vertices.contains(vertex)) {
            return 0;
        }
        
        return adjacencyList.get(vertex).size();
    }
    
    public int getVertexCount() {
        return vertices.size();
    }
    
    public int getEdgeCount() {
        return edgeCount;
    }
    
    public List<String> getAllVertices() {
        return new ArrayList<>(vertices);
    }
    
    public void clear() {
        adjacencyList.clear();
        vertices.clear();
        edgeCount = 0;
    }
}

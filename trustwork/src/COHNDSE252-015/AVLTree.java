package COHNDSE252_015;


import java.util.ArrayList;
import java.util.List;


/**
 * AVL Tree Implementation for worker profile management
 * Author: Member 1 (Senethma)
 * Maintains self-balancing property for O(log n) operations
 */
public class AVLTree<K extends Comparable<K>, V> {
   
    /**
     * AVL Tree Node class
     */
    private class AVLNode {
        K key;
        V value;
        AVLNode left;
        AVLNode right;
        int height;
       
        AVLNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
       
        int getHeight() {
            return height;
        }
       
        void updateHeight() {
            int leftHeight = (left != null) ? left.height : 0;
            int rightHeight = (right != null) ? right.height : 0;
            this.height = 1 + Math.max(leftHeight, rightHeight);
        }
       
        int getBalanceFactor() {
            int leftHeight = (left != null) ? left.height : 0;
            int rightHeight = (right != null) ? right.height : 0;
            return leftHeight - rightHeight;
        }
    }
   
    private AVLNode root;
    private int size;
   
    /**
     * Initialize empty AVL tree
     */
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }
   
    /**
     * Insert a key-value pair
     */
    public boolean insert(K key, V value) {
        if (search(key) != null) {
            return false; // Key already exists
        }
       
        root = insertRecursive(root, key, value);
        size++;
        return true;
    }
   
    /**
     * Recursively insert node and balance tree
     */
    private AVLNode insertRecursive(AVLNode node, K key, V value) {
        if (node == null) {
            return new AVLNode(key, value);
        }
       
        int cmp = key.compareTo(node.key);
       
        if (cmp < 0) {
            node.left = insertRecursive(node.left, key, value);
        } else if (cmp > 0) {
            node.right = insertRecursive(node.right, key, value);
        } else {
            return node; // Key already exists
        }
       
        node.updateHeight();
        return balanceNode(node);
    }
   
    /**
     * Search for value by key
     */
    public V search(K key) {
        AVLNode node = searchNode(root, key);
        return (node != null) ? node.value : null;
    }
   
    /**
     * Recursively search for node
     */
    private AVLNode searchNode(AVLNode node, K key) {
        if (node == null) {
            return null;
        }
       
        int cmp = key.compareTo(node.key);
       
        if (cmp < 0) {
            return searchNode(node.left, key);
        } else if (cmp > 0) {
            return searchNode(node.right, key);
        } else {
            return node;
        }
    }
   
    /**
     * Delete node by key
     */
    public boolean delete(K key) {
        int oldSize = size;
        root = deleteRecursive(root, key);
        return size < oldSize;
    }
   
    /**
     * Recursively delete node and rebalance
     */
    private AVLNode deleteRecursive(AVLNode node, K key) {
        if (node == null) {
            return null;
        }
       
        int cmp = key.compareTo(node.key);
       
        if (cmp < 0) {
            node.left = deleteRecursive(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteRecursive(node.right, key);
        } else {
            // Node found
            size--;
           
            if (node.left == null && node.right == null) {
                return null;
            }
           
            if (node.left == null) {
                return node.right;
            }
           
            if (node.right == null) {
                return node.left;
            }
           
            // Two children - find successor
            AVLNode successor = findMin(node.right);
            node.key = successor.key;
            node.value = successor.value;
            node.right = deleteRecursive(node.right, successor.key);
        }
       
        if (node != null) {
            node.updateHeight();
            node = balanceNode(node);
        }
       
        return node;
    }
   
    /**
     * Find node with minimum key
     */
    private AVLNode findMin(AVLNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
   
    /**
     * Balance node and perform rotations if needed
     */
    private AVLNode balanceNode(AVLNode node) {
        int balance = node.getBalanceFactor();
       
        // Left heavy
        if (balance > 1) {
            if (node.left.getBalanceFactor() < 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
       
        // Right heavy
        if (balance < -1) {
            if (node.right.getBalanceFactor() > 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        }
       
        return node;
    }
   
    /**
     * Perform right rotation
     */
    private AVLNode rotateRight(AVLNode node) {
        AVLNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
       
        node.updateHeight();
        newRoot.updateHeight();
       
        return newRoot;
    }
   
    /**
     * Perform left rotation
     */
    private AVLNode rotateLeft(AVLNode node) {
        AVLNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
       
        node.updateHeight();
        newRoot.updateHeight();
       
        return newRoot;
    }
   
    /**
     * In-order traversal
     */
    public List<K> inorderTraversal() {
        List<K> result = new ArrayList<>();
        inorderRecursive(root, result);
        return result;
    }
   
    /**
     * Recursively traverse in-order
     */
    private void inorderRecursive(AVLNode node, List<K> result) {
        if (node == null) {
            return;
        }
       
        inorderRecursive(node.left, result);
        result.add(node.key);
        inorderRecursive(node.right, result);
    }
   
    /**
     * Get all entries
     */
    public List<K> getAllKeys() {
        return inorderTraversal();
    }
   
    /**
     * Check if empty
     */
    public boolean isEmpty() {
        return root == null;
    }
   
    /**
     * Get size
     */
    public int getSize() {
        return size;
    }
   
    /**
     * Get height
     */
    public int getHeight() {
        return (root != null) ? root.height : 0;
    }
   
    /**
     * Clear tree
     */
    public void clear() {
        root = null;
        size = 0;
    }
}




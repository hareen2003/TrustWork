package member2;

import java.util.ArrayList;
import java.util.List;

/**
 * Doubly Linked List Implementation
 * Author: Member 2 (Perera)
 * Bidirectional traversal for job history
 */
public class DoublyLinkedList<T> {
    
    private class DLLNode {
        T data;
        DLLNode next;
        DLLNode prev;
        
        DLLNode(T data) {
            this.data = data;
        }
    }
    
    private DLLNode head;
    private DLLNode tail;
    private int size;
    
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public boolean insertAtHead(T data) {
        DLLNode newNode = new DLLNode(data);
        
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        
        size++;
        return true;
    }
    
    public boolean insertAtTail(T data) {
        DLLNode newNode = new DLLNode(data);
        
        if (tail == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        
        size++;
        return true;
    }
    
    public boolean deleteAtHead() {
        if (head == null) return false;
        
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
        }
        
        size--;
        return true;
    }
    
    public boolean deleteAtTail() {
        if (tail == null) return false;
        
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }
        }
        
        size--;
        return true;
    }
    
    public List<T> forwardTraversal() {
        List<T> result = new ArrayList<>();
        DLLNode current = head;
        
        while (current != null) {
            result.add(current.data);
            current = current.next;
        }
        
        return result;
    }
    
    public List<T> backwardTraversal() {
        List<T> result = new ArrayList<>();
        DLLNode current = tail;
        
        while (current != null) {
            result.add(current.data);
            current = current.prev;
        }
        
        return result;
    }
    
    public int getSize() {
        return size;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}

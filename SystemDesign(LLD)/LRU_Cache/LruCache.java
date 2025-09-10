import java.util.*;
class LruCache {
    static class Node{
        int key;
        int value;
        Node next;
        Node prev;
        Node(int key,int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    int capacity;
    Map<Integer,Node> map;
    Node head;
    Node tail;
    public LruCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))return -1;
        int val = map.get(key).value; // to return 
        delete(map.get(key)); // delete in list
        Node nodeAddress = insertFront(map.get(key)); //add new Node to List
        map.put(key,nodeAddress); // update in map
        return val; //return value
    }
    
    public void put(int key, int value) { 
        if(map.containsKey(key)){ // already exist
            delete(map.get(key)); // delete in list
            map.get(key).value = value; //upadate the value
            Node nodeAddress = insertFront(map.get(key));  //add new Node to List
            map.put(key,nodeAddress); // update in map
        }else{
            Node newNode = new Node(key,value); // create a newNode
            if(map.size() >= capacity){ //max capacity
                int delkey = deleteLast(); //delete last node 
                map.remove(delkey); //remove in map
            }
            Node nodeAddress = insertFront(newNode); // add node in list
            map.put(key,nodeAddress); // stort the key and address in map
        }
    }
    //helper functions
    // insertFront
    public Node insertFront(Node newNode){
        newNode.next = head.next;
        head.next = newNode;
        newNode.next.prev = newNode;
        newNode.prev = head;
        return head.next;
    }
    // delete
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // deletelast
    public int deleteLast(){
        int key =  tail.prev.key;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        return key;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
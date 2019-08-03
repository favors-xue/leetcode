import java.util.HashMap;
import java.util.Map;

/**
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2  capacity  );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4

**/

class LRUCache {


    class Node {
        int key;
        int value;
        Node pre = null;
        Node next = null;
        public Node(int key,int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity =0;

    private HashMap<Integer,Node> store = new HashMap<>();
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        Node n = store.get(key);
        if (n == null) return -1;
        put(key,n.value);
        return n.value;
    }

    public void put(int key, int value) {
        if (!store.containsKey(key)) {
            Node n = new Node(key, value);
            n.next = head.next;
            n.pre = head;
            head.next.pre = n;
            head.next = n;
            store.put(key,n);
            if (store.size()>capacity) {
                Node r = tail.pre;
                store.remove(r.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
                r = null;
            }

        }
        else {
            Node n = store.get(key);
            //remove from the origin
            n.pre.next = n.next;
            n.next.pre = n.pre;
            //add to the first
            n.next = head.next;
            head.next.pre = n;
            n.pre = head;
            head.next = n;
            n.value = value;

        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

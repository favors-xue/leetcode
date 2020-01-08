/**
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );
/*
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/
class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key , int value) {
            this.key =  key;
            this.value = value;
        }
    }
    Map<Integer, Node> cache = new HashMap<>();
    Node head ;
    Node tail ;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node n = cache.get(key);
            put(key,n.value);
            return n.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            //get node, rebuild node, priority Node
            Node n = cache.get(key);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            n.next = head.next;
            n.pre = head;
            head.next = n;
            n.value = value;
        }
        else {
            Node n = new Node(key,value);
            n.next = head.next;
            n.pre = head;
            head.next.pre = n;
            head.next = n;
            cache.put(key,n);
            if (cache.size()>this.capacity) {
                cache.remove(tail.pre.key);
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;

            }

        }
    }
}

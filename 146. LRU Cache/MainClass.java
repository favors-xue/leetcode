public class MainClass {

    public  static void main(String... args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));       // returns 1
        cache.put(1, 1);    // evicts key 2
        cache.put(4, 1);    // evicts key 1
        System.out.println(cache.get(2));       // returns -1 (not found)
    }

}

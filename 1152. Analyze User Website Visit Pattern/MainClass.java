public class MainClass {
    public static void main(String... args) {
        String[] username = {"joe","joe","joe","james","james","james","james","mary","mary","mary"};
        int[] time = {1,2,3,4,5,6,7,8,9,10};
        String[] web = {"home","about","career","home","cart","maps","home","home","about","career"};
        Solution s = new Solution();
        s.mostVisitedPattern(username,time,web);
    }
}

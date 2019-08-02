public class MainClass {
    public static void main(String... args) {
        Solution s = new Solution();
        int[][] test = {{1,2},{1,3},{2,4}};
        boolean result = s.possibleBipartition(4,test);
        System.out.println(test);
    }
}

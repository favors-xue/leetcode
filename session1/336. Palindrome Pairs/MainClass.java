import java.util.List;

public class MainClass {
    public static void main(String... args) {
        Solution s = new Solution();
        String[] tc = new String[]{"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> result = s.palindromePairs(tc);
        System.out.println(result);
    }
}

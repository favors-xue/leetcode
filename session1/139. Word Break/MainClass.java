import java.util.Arrays;

public class MainClass {
    public static void main(String... args) {
        Solution s = new Solution();
        String str = "leetcodeleet";
        String[] arr = new String[] {"leet","code"};
        s.wordBreak(str, Arrays.asList(arr));

    }
}

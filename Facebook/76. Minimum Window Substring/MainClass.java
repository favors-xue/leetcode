public class MainClass {

    public static void main(String... args) {
        Solution s = new Solution();
        String tc1 = "ADOBECODEBANC,ABC";
        String tc2 = "AA,AA";
        String tc3 = "ADFEADFEFDAAAEDD,AA";
        String tc4 = "a,b";
        String tc5 = "ab,A";
        String[] arr =tc5.split(",");
        String str = s.minWindow(arr[0],arr[1]);
    }
}

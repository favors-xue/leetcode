public class ClassMain {
    public static void main(String... args) {
        int[] tmp = {3,4,-1,1};
        int[] tmp1 = {8,6,15,9};
        Solution s = new Solution();
        int res = s.firstMissingPositive(tmp1);
        System.out.println(res);

    }
}

public class MainClass {

    public static void main(String... args) {
        Solution s = new Solution();

        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(s.maxSubArray(test));


        int[] test2 = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println(s.maxSubArray(test2));

        int[] test3 = {-2,-1};
        System.out.println(s.maxSubArray(test3));
    }
}

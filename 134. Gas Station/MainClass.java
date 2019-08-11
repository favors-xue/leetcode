public class MainClass {
    public static void main(String... args) {
        int[] gas = {2,1,2,6};
        int[] cost = {1,3,3,3};
        Solution s = new Solution();
        int index = s.canCompleteCircuit(gas,cost);
        System.out.println(index);
    }
}

public class MainClass {

    public static void main(String... args) {
        Solution s = new Solution();
        //[[0, 30],[5, 10],[15, 20]]
        int[][] tc1 = new int[][]{
                {0,30},
                {5,10},
                {15,20}
        };
        int size = s.minMeetingRooms(tc1);
    }
}

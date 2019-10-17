import java.util.Arrays;
import java.util.PriorityQueue;

/**
253. Meeting Rooms II
Medium

1748

29

Favorite

Share
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length<2) return 1;

        Arrays.sort(intervals,(a, b)->(a[0]-b[0]));
        PriorityQueue<int[]> rooms = new PriorityQueue<>((a, b)->(a[1]-b[1]));
        rooms.add(intervals[0]);
        for (int i=1;i<intervals.length;i++) {
            int[] curr = intervals[i];
            int[] earlist = rooms.remove();
            if (curr[0]>=earlist[1]) {
                earlist[1] = curr[1];
            }
            else {
                rooms.add(curr);
            }
            rooms.add(earlist);

        }
        return rooms.size();
    }
}

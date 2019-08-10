/**
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:
[1,4] [5,6]
1,5
4,6
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<2) return intervals;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i=0;i<intervals.length;i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int indexStart = 0,indexEnd = 0,num = 0;
        while(indexStart<start.length || indexEnd < end.length) {
            int[] interval = new int[2];
            interval[0] = start[indexStart++];
            while (indexStart<start.length && end[indexEnd]>= start[indexStart]) {
                indexEnd++;
                indexStart++;
            }
            interval[1] = end[indexEnd++];
            intervals[num] = interval;
            num++;
        }
        int[][] result = new int[num][2];
        for (int i=0;i<num;i++) {
            result[i] = intervals[i];
        }
        return result;

    }
}

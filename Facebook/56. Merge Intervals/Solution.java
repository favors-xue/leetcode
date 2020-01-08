import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
56. Merge Intervals
Medium

2630

207

Favorite

Share
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
**/
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
        int indexStart = 0, indexEnd = 0, pos = 0;
        while(indexStart <intervals.length || indexEnd<intervals.length) {
            int[] interval = new int[2];
            interval[0] = start[indexStart++];
            while(indexStart<intervals.length && end[indexEnd] >= start[indexStart]) {
                indexEnd++;
                indexStart++;
            }
            interval[1] = end[indexEnd++];
            intervals[num++] = interval;

        }
        int[][] result = new int[num][2];
        for (int i=0;i<num;i++) {
            result[i] = intervals[i];
        }
        return result;
    }
    
    public int[][] merge2(int[][] intervals) {
        PriorityQueue<int[]> pg = new PriorityQueue<>((a, b)->a[0]-b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        pg.addAll(Arrays.asList(intervals));
        List<int[]> mergeList = new ArrayList<>();
        while(!pg.isEmpty()) {
            int[] first = pg.poll();
            int[] second = pg.peek();
            if (second != null && second[0]<first[1]) {
                pg.poll();
                pg.add(new int[] {first[0], Math.max(first[1],second[1])});
            }
            else {
                mergeList.add(first);
            }
        }

        return mergeList.toArray(new int[mergeList.size()][]);

    }
}

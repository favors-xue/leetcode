/**
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
Note:

You can assume that you can always reach the last index.
*/
class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length ==0) return 0;
        int cur = 0, i=0, level =0, maxNext = 0;
        while (cur-i+1>0) {
            level++;
            for (;i<=cur;i++) {
                maxNext = Math.max(cur,i+num[i]);
                if (maxNext>nums.length-1) {
                    return level;
                }
            }
            cur = maxNext;
        }
        return 0;
    }
}

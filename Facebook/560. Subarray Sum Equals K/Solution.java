import java.util.HashMap;
import java.util.Map;

/**
560. Subarray Sum Equals K
Medium

2582

72

Favorite

Share
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
Note:
The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
Accepted
148,497
Submissions
345,471
*/
class Solution {

    public int subarraySum1(int[] nums, int k) {
        Map<Integer,Integer> heap = new HashMap<>();
        int sum = 0;
        int result = 0;
        heap.put(0, 1);
        for (int i: nums) {
            sum += i;
            result += heap.getOrDefault(sum-k,0);
            heap.put(sum,heap.getOrDefault(sum,0)+1);
        }
        return result;
    }
    public int subarraySum(int[] nums, int k) {
        if (nums == null) return 0;
        if (nums.length == 1) return nums[0] == k?1:0;
        int[][] dp = new int[nums.length][nums.length];
        dp[0][0] = nums[0];
        int num = nums[0] == k?1:0;
        for (int i=0;i<nums.length;i++) {
            for (int j=i;j<nums.length;j++) {
                if (i==0&&j==0) continue;
                dp[i][j] = dp[i][j-1]+nums[j];
                if (dp[i][j]==k){
                    num++;
                }
            }
        }
        return num;
    }
}

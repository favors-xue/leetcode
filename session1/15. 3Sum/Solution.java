import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length <3) return result;
        Arrays.sort(nums);
        for (int i = 0;i<nums.length-2;i++) {
            if (i>0 && nums[i] == nums[i-1]) continue;
            int low = i+1, high = nums.length-1, res = 0-nums[i];
            while(low<high) {
                if(nums[low] + nums[high] == res) {
                    List<Integer> record = Arrays.asList(nums[i],nums[low],nums[high]);
                    result.add(record);
                    while(low<high && nums[low] == nums[low+1]) low++;
                    while(low>high && nums[high] == nums[high-1]) high--;
                    low++;
                    high--;
                }
                else if (nums[low] + nums[high] < res) {
                    low ++;
                }
                else {
                    high--;
                }
            }
        }
        return result;
    }
}

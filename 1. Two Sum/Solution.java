import java.util.HashMap;
import java.util.Map;

/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
**/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> con = new HashMap<>();
        int[] result = new int[2];
        for (int i =0;i<nums.length;i++) {
            int rest = target - nums[i];
            if (con.get(rest)==null) {
                con.put(nums[i], i);
            }
            else{
                result[0] = con.get(rest) >= i?i:con.get(rest);
                result[1] = con.get(rest) > i?con.get(rest):i;
                break;
            }
        }
        return result;
    }
}

import java.util.HashMap;
import java.util.Map;

/**
 *  Given an array of integers, return indice
 *  of the two numbers such that they add up to a specific target. You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example: Given nums = [2, 7, 11, 15], target
 * =  Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
class Solution {
    /**
     * Using hashmap as cache to store the result of the target - nums[i],
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null) return null;
        int[] output = new int[2];
        Map<Integer,Integer> reusltCache = new HashMap<>();
        for (int i = 0;i<nums.length;i++) {            
            if (reusltCache.containsKey(nums[i])) {
                output[0] = reusltCache.get(nums[i]);
                output[1] = i;
                return output;
            }
            int result = target - nums[i];
            reusltCache.put(result,i);
        }
        return output;
    }
    
}
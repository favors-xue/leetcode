import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer> result = new HashMap<>();
        for (int i = 0;i<nums1.length;i++) {
            if (result.containsKey(nums1[i])) {
                continue;
            }
            result.put(nums1[i],nums1[i]);
        }
        List<Integer> arr = new ArrayList<>();
        for (int i = 0;i<nums2.length;i++) {
            if (result.containsKey(nums2[i])) {
                arr.add(nums2[i]);
                result.remove(nums2[i]);
            }
        }
        int[] res = new int[arr.size()];
        for (int i=0;i<arr.size();i++) {
            res[i] = arr.get(i);
        }
        return res;
    }
}

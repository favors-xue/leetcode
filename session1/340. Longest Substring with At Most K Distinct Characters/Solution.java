/**
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Example 1:

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
Example 2:

Input: s = "aa", k = 1
Output: 2
Explanation: T is "aa" which its length is 2.
*/
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() ==0 || k ==0 ) return 0;
        int[] p = new int[256];
        int left = 0,max = 0, count=0;
        for (int right=0;right<s.length();right++) {
            if (p[s.charAt(right)]==0) {
                count++;
            }
            p[s.charAt(right)]++;
            while (count > k) {
                p[s.charAt(left)]--;
                if (p[s.charAt(left++)]==0) {
                    count--;
                }
            }
            max = Math.max(max,right-left+1);
        }
        return max;
    }
}

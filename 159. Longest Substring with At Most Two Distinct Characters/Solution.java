/**
Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.

Example 1:

Input: "eceba"
Output: 3
Explanation: t is "ece" which its length is 3.
Example 2:

Input: "ccaabbb"
Output: 5
Explanation: t is "aabbb" which its length is 5.
*/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() ==0) return 0;
        int[] c = new int[256];
        int left = 0, max = 0,count=0;
        for (int right =0;right<s.length();right++) {
            if (c[s.charAt(right)]!=0) {
                c[s.charAt(right)]++;
                if (count<=2) {
                    max = Math.max(max,right-left+1);
                }
                continue;
            }
            c[s.charAt(right)]++;
            count++;
            if (count<=2) {
                max = Math.max(max,right-left+1);
            }
            while(left<right && count>2) {
                c[s.charAt(left)]--;
                if (c[s.charAt(left)]==0) count--;
                left++;
            }

        }
        return max;
    }
}

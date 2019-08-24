/**
Given a string, determine if a permutation of the string could form a palindrome.

Example 1:

Input: "code"
Output: false
Example 2:

Input: "aab"
Output: true
Example 3:

Input: "carerac"
Output: true
*/
class Solution {
    public boolean canPermutePalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        if (s.length() == 1) return true;
        char[] cs = s.toCharArray();
        int[] count = new int[256];
        for (char c : cs) {
            count[c]++;
        }
        boolean odd = false;
        for (int i: count) {
            if (i%2==1) {
                if (odd) return false;
                odd = true;
            }
        }
        return true;
    }
}

/**
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
*/
xxx[ji]
dp[i] = Math.max(dp[j-1]+1,dp[i])
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int[] dp = new int[s.length()];
        for (int i=1;i<s.length();i++) {
            for (int j=0;j<i;j++) {
                if ()
                if (isValid(j,i)) {

                }
            }
        }
    }
}

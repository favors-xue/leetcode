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
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() < 2) return 0;
        int left = -1, max =0;
        Stack<Integer> cache = new Stack<>();
        for (int right =0;right<s.length();right++) {
            if (s.charAt(right)=='(') {
                cache.push(right);
            }
            else {
                if (cache.isEmpty()) {
                    left = right
                }
                else {
                    cache.pop();
                    if (cache.isEmpty()) {
                        max = Math.max(max, right-left);
                    }
                    else {
                        max = Math.max(max, right-cache.peak());
                    }
                }
            }
        }
        return max;

    }
}

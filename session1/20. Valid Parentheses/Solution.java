import java.util.Stack;

/**
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() ==0) return true;
        Stack<Character> heap = new Stack<>();
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                heap.push(c);
            }
            else {
                if (heap.isEmpty()) return false;
                Character b = heap.pop();
                if (( b == 40 && c== 41) || (c-b)==2) {
                    continue;
                }
                else {
                    return false;
                }
            }
        }
        return heap.isEmpty();
    }
}

/**
Given an input string , reverse the string word by word.

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note:

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?

*/
class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length ==0) return;
        reverse(0,s.length-1,s);
        int start = 0;
        for (int i=0;i<=s.length;i++) {
            if (i == s.length || s[i] == ' ') {
                reverse(start,i-1,s);
                while (i < s.length && s[i] == ' ') {
                    i++;
                }
                start = i;
            }
        }
    }

    private void reverse(int start, int end, char[] s) {
        while (start < end) {
            char tmp = s[start];
            s[start] = s[end];
            s[end] = tmp;
            start++;
            end--;
        }
    }
}

/**
186. Reverse Words in a String II
Medium

304

84

Favorite

Share
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
        reverse(s, 0, s.length-1);
        int start = 0;
        for (int i= 0;i<=s.length;i++) {
            if (i==s.length || s[i] == ' ' ) {
                reverse(s,start,i-1);
            }
            while(i<s.length&&s[i]==' ') {
                i++;
            }
            start = i;
        }
    }
}

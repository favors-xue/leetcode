/**
Given an input string, reverse the string word by word.



Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.


Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.

*/
class Solution {
    public String reverseWords(String s) {
        if (s== null || s.length()==0) return s;
        String[] arrStr = s.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = arrStr.length-1;i>=0;i--) {
            output.append(arrStr[i]);
            if (arrStr[i].length()==0){
                continue;
            }
            if (i+1<arrStr.length) {
                output.append(" ");
            }
        }
        return output.toString();
    }
}

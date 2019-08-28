import java.util.ArrayList;
import java.util.List;

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
        if (s == null || s.length() <2) return s.trim();
        List<String> cache = new ArrayList<>();
        String[] words = s.split(" ");
        int start = 0, end = words.length-1;
        while (start < end) {
            String tmp = "";
            tmp = words[start];
            words[start] = words[end];
            words[end] = tmp;
            start++;
            end--;
        }
        StringBuffer sb = new StringBuffer();
        for (int i=0;i<words.length;i++) {
            if (words[i].equals("")) continue;
            sb.append(words[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}

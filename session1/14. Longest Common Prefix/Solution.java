/**
14. Longest Common Prefix
Easy

1546

1423

Favorite

Share
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length ==0) {
            return "";
        }
        String str = strs[0];
        String res = "";
        for (int i =0;i<str.length();i++) {
            char c = str.charAt(i);
            for (int j=1;j<strs.length;j++) {
                if (i==strs[j].length() || strs[j].charAt(i)!=c) {
                    return res;
                }
            }
            res+=String.valueOf(c);
        }
        return res;
    }
}

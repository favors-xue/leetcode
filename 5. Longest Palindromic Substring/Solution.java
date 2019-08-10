/**
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
**/
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String res = "";
        for (int i = 0 ; i< s.length();i++) {
            for (int j =0; j<=i;j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((i - j <=2) || dp[i-1][j+1]);
                if (dp[i][j]) {
                    if (i - j +1 >max) {
                    max =  i - j +1;

                    res = s.substring(j, i+1);
                    }
                }
            }
        }
        return res;
    }
}

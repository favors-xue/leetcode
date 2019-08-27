/**
Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
Accepted
69,474
Submissions
144,747
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() ==0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        int max = 0;
        for (int level = 0;level<s.length();level++) {
            for (int i=0;i+level<s.length();i++) {
                int j = i+level;
                if (level == 0) dp[i][j] = 1;
                else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i-1][j-1]+2;
                    }
                    else {
                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


}

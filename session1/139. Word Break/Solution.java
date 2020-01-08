import java.util.List;

/**
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
*/
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        for (int i=s.length();i>=0;i--) {
            if (i == s.length()) {
                dp[i] = true;
            }
            else {
                dp[i] = false;
                for (String word : wordDict) {
                    if (i+word.length()<=s.length() && s.substring(i,i+word.length()).equals(word) && dp[i+word.length()]) {
                        dp[i] = true;
                    }
                }
            }
        }
        return dp[0];
    }
}

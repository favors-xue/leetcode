/**
647. Palindromic Substrings
Medium

1596

82

Favorite

Share
Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".


Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Note:

The input string length won't exceed 1000.
*/
class Solution {


    public int countSubstrings(String s) {
        if (s == null || s.length() ==0 ) return 0;
        if (s.length()<2) return 1;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        dp[0][0] = true;
        for (int i=1;i<s.length();i++) {
            for (int j=0;j<=i;j++) {
                if (i==j) {
                    count++;
                    dp[i][j] = true;
                }
                else {
                    if (s.charAt(i)==s.charAt(j) && dp[i-1][j+1]) {
                        count ++;
                        dp[i][j] = true;
                    }
                }
            }
        }
        return count;
    }

    public int countSubstrings2(String s) {
        int counter = s.length(); // Since all single digits are palindromes, you can start at the length

        for(int i = 0, first, last, len = s.length(); i < len; i ++) {

		    // Checks all the possible palindromes with i as its middle point.     start at i - 1 and i + 1 since I already calculated the single digits.
            for(first = i - 1, last = i + 1; first >= 0 && last < len && s.charAt(first) == s.charAt(last); first --, last ++) {
                counter ++;
            }

			// // Checks all the possible palindromes with two middle points, i - 1 and i
            for(first = i - 1, last = i; first >= 0 && last < len && s.charAt(first) == s.charAt(last); first --, last ++) {
                counter ++;
            }
        }

        return counter;
    }

    public int countSubstirng3(String s) {
        int count = s.length();
        for (int i=0;i<s.length();i++) {
            for (int first = i-1,last = i+1;first>=0 && last<s.length();first--,last++) {
                count++;
            }
            for (int first = i-1,last = i; first>=0 && last<s.length();first--,last++) {
                count++;
            }
        }
        return count;
    }
}

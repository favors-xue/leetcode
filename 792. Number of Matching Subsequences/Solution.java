/**
Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.

Example :
Input:
S = "abcde"
words = ["a", "bb", "acd", "ace"]
Output: 3
Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
Note:

All words in words and S will only consists of lowercase letters.
The length of S will be in the range of [1, 50000].
The length of words will be in the range of [1, 5000].
The length of words[i] will be in the range of [1, 50].

**/
class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int start = 0,result = 0;

        for (String word: words) {
            if (word.length() == 0) continue;
            if (word.length() > S.length()) continue;
            if ( word.length() ==  S.length() && word != S) continue;
            start = 0;
            boolean flag = true;
            for (int i = 0;i<word.length();i++) {
                int index = S.indexOf(word.charAt(i),start);
                if (index < 0) {
                    flag = false;
                    break;
                }
                else {
                    start = index +1;
                }
            }
            if (flag == true)
                result ++;
        }
        return result;
    }
}

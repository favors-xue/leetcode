/**
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

*/
class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words.length<3) return 1;
        int l1 = -1, l2=-1, dis = Integer.MAX_VALUE;
        for (int i=0;i<words.length;i++) {
            if (word1.equals(words[i])) {
                l1 = i;
                if (l2 == -1) continue;
                dis = Math.min(dis,Math.abs(l2-l1));
                continue;

            }
            if (word2.equals(words[i])) {
                l2 = i;
                if (l1 == -1) continue;
                dis = Math.min(dis, Math.abs(l2-l1));
                continue;
            }

        }
        return dis;
    }
}

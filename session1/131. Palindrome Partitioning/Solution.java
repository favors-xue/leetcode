import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length()==0) return res;
        List<String> cur = new LinkedList<>();
        dfs(0, s.length()-1,s,cur,res);
        return res;
    }

    void dfs(int start, int end, String s, List<String> cur, List<List<String>> result) {
        if (start > end) {
            result.add(new LinkedList<>(cur));
            return;
        }

        for (int i=start;i<=end;i++) {
            if (isValid(s,start,i)) {
                cur.add(s.substring(start,i+1));
                dfs(i+1,end,s,cur,result);
                cur.remove(cur.size()-1);
            }
        }
    }

    boolean isValid(String word,int start, int end) {
        while (start < end) {
            if (word.charAt(start++)!=word.charAt(end--)) return false;
        }
        return true;
    }


}

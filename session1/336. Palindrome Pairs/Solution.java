import java.util.*;

/**
Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

Example 1:

Input: ["abcd","dcba","lls","s","sssll"]
Output: [[0,1],[1,0],[3,2],[2,4]]
Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
Example 2:

Input: ["bat","tab","cat"]
Output: [[0,1],[1,0]]
Explanation: The palindromes are ["battab","tabbat"]
*/
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length ==0) return result;
        Map<String,Integer> cache = new HashMap<>();
        List<Integer> empty =new ArrayList<>();
        for (int i=0;i<words.length;i++) {
            if (words[i].length()==0){
                empty.add(i);
            }
            else {
                cache.put(new StringBuilder(words[i]).reverse().toString(),i);
            }
        }

        for (int i=0;i<words.length;i++) {
            if (words[i].length()==0) continue;
            if (valid(words[i])) {
                for (Integer k: empty) {
                    result.add(Arrays.asList(k,i));
                    result.add(Arrays.asList(i,k));
                }
            }

            for (int j=0;j<words[i].length();j++) {
                String pre = words[i].substring(0,j);
                String suf = words[i].substring(j);
                if (valid(pre) && cache.containsKey(suf) && cache.get(suf)!=i) {
                    result.add(Arrays.asList(cache.get(suf),i));
                }
                if (valid(suf) && cache.containsKey(pre) && cache.get(pre)!=i) {
                    result.add(Arrays.asList(i,cache.get(pre)));
                }
            }
        }
        return result;
    }

    boolean valid(String word) {
        int left =0, right = word.length()-1;
        while (left<right) {
            if (word.charAt(left++) != word.charAt(right--)) return false;
        }
        return true;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length ==0) return res;
        HashMap<String,List<String>> cache = new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            char[] cs = strs[i].toCharArray();
            Arrays.sort(cs);
            if (!cache.containsKey(String.valueOf(cs))) {
                cache.put(String.valueOf(cs),new ArrayList<String>(Arrays.asList(new String[]{strs[i]})));
            }
            else {
                cache.get(String.valueOf(cs)).add(strs[i]);
            }

        }
        for (String key: cache.keySet()) {
            res.add(cache.get(key));
        }
        return res;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;
        HashMap<String, List<String>> cache = new HashMap<>();

        for (int i=0;i<strs.length;i++) {
            String str = "";
            int[] count = new int[26];
            for (int j=0;j<strs[i].length();j++) {
                count[strs[i].charAt(j)-'a']++;
            }
            for (int j=0;j<count.length;j++) {
                str+=String.valueOf(count[j])+String.valueOf((char)(j+'a'));
            }
            if (cache.containsKey(str)){
                cache.get(str).add(strs[i]);
            }
            else {
                List<String> r = new ArrayList<>();
                r.add(strs[i]);
                cache.put(str,r);
            }
        }
        for (String key: cache.keySet()) {
            res.add(cache.get(key));
        }
        return res;
    }
}

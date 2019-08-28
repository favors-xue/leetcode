import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

Example:

Input: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
Output:
[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
*/
class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings == null || strings.length == 0) return res;
        HashMap<String, List<String>> cache = new HashMap<>();
        for(String str : strings) {
            String des = "";
            char[] cs = str.toCharArray();
            for (int i=0;i<cs.length-1;i++) {
                int dis = ((cs[i]-'a')-(cs[i+1]-'a'))>0?((cs[i]-'a')-(cs[i+1]-'a'))-25:((cs[i]-'a')-(cs[i+1]-'a'))+1;
                des += String.valueOf(Math.abs(dis));
            }
            if (cache.containsKey(des)) {
                cache.get(des).add(str);
            }
            else {
                List<String> arr = new ArrayList<>();
                arr.add(str);
                cache.put(des,arr);
            }
        }
        for (String key: cache.keySet()) {
            res.add(cache.get(key));
        }
        return res;
    }
}

/**
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        HashMap<Character,String> cache = new HashMap<>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length) return false;
        for (int i=0;i<pattern.length();i++) {
            if (cache.containsKey(pattern.charAt(i))){
                if (!cache.get(pattern.charAt(i)).equals(strs[i])) {
                    return false;
                }
            }
            else {
                if (cache.containsValue(strs[i])) {
                    return false;
                }
                cache.put(pattern.charAt(i),strs[i]);
            }
        }
        return true;
    }
}

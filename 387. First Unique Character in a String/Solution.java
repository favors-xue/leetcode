/**
Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
*/
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> cache = new HashMap<>();
        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if (cache.get(c) != null) {
                cache.put(c,cache.get(c)+1);
            }
            else {
                cache.put(c,1);
            }
        }
        for (int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if (cache.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

/**
Runtime: 9 ms, faster than 78.00% of Java online submissions for First Unique Character in a String.
Memory Usage: 37.4 MB, less than 100.00% of Java online submissions for First Unique Character in a String.
Next challenges:
*/
//Using array is faster than hashmap
    public int firstUniqChar2(String s) {
        int[] cache = new int[26];
        for (int i=0;i<s.length();i++) {
            cache[s.charAt(i)-'a']++;
        }
        for (int i=0;i<s.length();i++) {
            if (cache[s.charAt(i)-'a'] == 1)
                return i;
        }
        return -1
    }

}

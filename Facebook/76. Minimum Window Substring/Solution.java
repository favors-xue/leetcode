import java.util.HashMap;
import java.util.Map;

/**
76. Minimum Window Substring
Hard

2886

203

Favorite

Share
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/
class Solution {
    public String minWindow1(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> cache = new HashMap<>();
        for (int i=0;i<t.length();i++) {
            if (cache.containsKey(t.charAt(i))) {
                cache.put(t.charAt(i), cache.get(t.charAt(i))+1);
            }
            else {
                cache.put(t.charAt(i),1);
            }
        }
        int slow=0, matchCount=0, minLen = Integer.MAX_VALUE, index = 0;
        for (int fast = 0;fast<s.length(); fast++) {
            char c = s.charAt(fast);
            Integer count = cache.get(c);
            if (count == null) {
                continue;
            }
            cache.put(c,count-1);
            if (count==1) {
                matchCount++;
            }
            while (matchCount==cache.size()) {
                if (fast-slow+1<minLen) {
                    minLen = fast-slow+1;
                    index = slow;
                }
                char left = s.charAt(slow++);
                Integer leftCount = cache.get(left);
                if (leftCount==null) {
                    continue;
                }
                cache.put(left, leftCount+1);
                if (leftCount==0) {
                    matchCount--;
                }
            }

        }
        return s.substring(index,index+minLen);
    }

    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        if (s.length()==1) {
            return s == t ? s : "";
        }
        Map<Character, Integer> cache = new HashMap<>();
        for (Character c : t.toCharArray()) {
            if (cache.containsKey(c)) {
                cache.put(c, cache.get(c)+1);
            }
            else {
                cache.put(c, 1);
            }
        }

        int slow = 0, matchCount =0, index = 0, minLen = Integer.MAX_VALUE;
        for (int fast = 0;fast<s.length();fast++) {
            Character ch = s.charAt(fast);
            if (!cache.containsKey(ch)) {
                continue;
            }
            cache.put(ch, cache.get(ch)-1);
            if (cache.get(ch)==0) {
                matchCount++;
            }
            while (matchCount == cache.size()) {
                if (fast-slow+1<minLen) {
                    minLen = fast-slow+1;
                    index = slow;
                }
                Character leftCh = s.charAt(slow++);
                if (!cache.containsKey(leftCh)) {
                    continue;
                }
                cache.put(leftCh, cache.get(leftCh)+1);
                if (cache.get(leftCh)==0) {
                    matchCount--;
                }
            }
        }
        return minLen == Integer.MAX_VALUE? "":s.substring(index, index+minLen);

    }
}

/**
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabbca", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/
class Solution {
    int max = 0;
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() ==0 || k ==0) return 0;
        int[] count = new int[26];
        if (s.length()<=max || s.length()<k) return max;

        for (int i=0;i<s.length();i++) {
            count[s.charAt(i)-'a']++;
        }
        if (valid(count,k)) return  s.length();
        StringBuilder sb = new StringBuilder();
        for(char c: s.toCharArray()) {
            if (count[c-'a']<k) {
                max = Math.max(max,longestSubstring(sb.toString(),k));
                sb = new StringBuilder();

            }
            else {
                sb.append(c);
            }
        }
        return Math.max(max,longestSubstring(sb.toString(),k));
    }

    boolean valid(int[] count, int k) {
        for (int i=0;i<count.length;i++) {
            if (count[i]>0 && count[i] < k) return false;

        }
        return true;
    }


}

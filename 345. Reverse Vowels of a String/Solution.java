/**
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
*/
class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() ==0) return s;
        char[] cs = s.toCharArray();
        int start = 0, end =s.length()-1;
        while (start < end) {
            while(start<end && cs[start]!='a' && cs[start]!='e' && cs[start]!='i'&& cs[start]!='o'&&cs[start]!='u' &&cs[start]!='A' && cs[start]!='E' && cs[start]!='I'&& cs[start]!='O'&&cs[start]!='U') {
                start++;
            }
            while (end>start && cs[end]!='a' && cs[end]!='e' && cs[end]!='i'&& cs[end]!='o'&&cs[end]!='u'&&cs[end]!='A' && cs[end]!='E' && cs[end]!='I'&& cs[end]!='O'&&cs[end]!='U') {
                end --;
            }
            if (start == end) break;
            char tmp = cs[start];
            cs[start] = cs[end];
            cs[end] = tmp;
            start++;
            end--;
        }
        return String.valueOf(cs);
    }
}

/**
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaa"
Example 2:

 aacecaaa
aaacecaa

Input: "abcd"dcba
Output: "dcbabcd"
*/
class Solution {
    public String shortestPalindrome(String s) {
        if (s==null || s.length()<2) return s;
        String re = new StringBuilder(s).reverse().toString();
        if (re.equals(s)) return s;
        int i = s.length()-1;
        while (i>=0) {
            String pre = s.substring(0,i);
            String suf = re.substring(re.length()-pre.length());
            if (pre.equals(suf)) {
                String str = re.substring(0,re.length()-pre.length());
                return str+s;
            }
            i--;
        }
        return s;

    }

    public String shortestPalindrome2(String s) {
        if(s.equals("")) return "";
        int j=0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(j)==s.charAt(i)) j++;
        }
        if(j==s.length()) return s;
        String suffix = s.substring(j);
        return new StringBuffer(suffix).reverse().toString() + shortestPalindrome2(s.substring(0, j)) + suffix;

    }
}

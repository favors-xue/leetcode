/**
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
Example 2:

Input: "race a car"
Output: false
*/
class Solution {
    int dif = 'a'-'A';
    public boolean isPalindrome(String s) {
        if (s == null || s.length() <2) return true;
        int left = 0, right  = s.length()-1;
        char[] cs = s.toCharArray();
        while (left<right) {
            if (cs[left]>='A' && cs[left]<='Z') cs[left]+=dif;
            if (cs[right]>='A' && cs[right]<='Z') cs[right]+=dif;

            if (!isValid(cs[left])) {
                left++;
                continue;
            }
            if (!isValid(cs[right])) {
                right--;
                continue;
            }
            if (cs[left]!=cs[right]) return false;
            right--;
            left++;
        }
        return true;
    }
    boolean isValid(char c) {
        if ((c >='a' && c<='z') || (c>='0'&&c<='9')) {
            return true;
        }
        return false;
    }

}

/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
*/
class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int count = 0;
        for (int i=s.length()-1;i>=0;i--) {
            while(i>=0 && count==0 && s.charAt(i)==' '){
                i--;
            }
            if(i<0 || s.charAt(i)==' ')
                return count;
            count++;
        }
        return count;
    }
}

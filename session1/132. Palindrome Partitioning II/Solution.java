/**
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

class Solution {
    public int minCut(String s) {
        int[] cuts = new int[s.length()+1];
        for (int i=0;i<s.length();i++) {
            cuts[i] = i;
        }
        for (int i=0;i<s.length();i++) {
            helper(s,cuts,i,i);
            helper(s,cuts,i,i+1);
        }
        return cuts[s.length()-1];
    }

    void helper(String s, int[] cuts, int start, int end) {
        while(start< end && s.charAt(start)==s.charAt(end)) {
            if (start==0){
                cuts[end] = 0;
            }
            else {
                cuts[end] =Math.min(cuts[end],cuts[start-1]+1);
                start++;
                end--;
            }
        }
    }
}

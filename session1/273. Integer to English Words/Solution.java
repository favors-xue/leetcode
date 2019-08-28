/**
Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

Example 1:

Input: 123
Output: "One Hundred Twenty Three"
Example 2:

Input: 12,345
Output: "Twelve Thousand Three Hundred Forty Five"
Example 3:

Input: 1,234,567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Example 4:

Input: 1,234,567,891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
*/

class Solution {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        String res = "";
        int i = num /1000;
        while (num != 0) {
            int m = num%1000;
            int h = num/1000;
        }
    }
}

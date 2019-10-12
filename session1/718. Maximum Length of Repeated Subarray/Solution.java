/**
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation:
The repeated subarray with maximum length is [3, 2, 1].


Note:

1 <= len(A), len(B) <= 1000
0 <= A[i], B[i] < 100
*/


class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for (int i=0;i<B.length;i++) {
            dp[0][i] = A[0] == B[i]?1:0;
        }
        for (int i=0;i<A.length;i++) {
            dp[i][0] = A[i] == B[0]?1:0;
        }
        int max = 0;
        for (int i=1;i<A.length;i++) {
            for (int j=1;j<B.length;j++) {
                dp[i][j] = A[i] == B[j] ? dp[i-1][j-1]+1:0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}

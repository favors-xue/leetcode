/**
Given a binary array data, return the minimum number of swaps required to group all 1’s present in the array together in any place in the array.



Example 1:

Input: [1,0,1,0,1]
Output: 1
Explanation:
There are 3 ways to group all 1's together:
[1,1,1,0,0] using 1 swap.
[0,1,1,1,0] using 2 swaps.
[0,0,1,1,1] using 1 swap.
The minimum is 1.
Example 2:

Input: [0,0,0,1,0]
Output: 0
Explanation:
Since there is only one 1 in the array, no swaps needed.
Example 3:

Input: [1,0,1,0,1,0,0,1,1,0,1]
Output: 3
Explanation:
One possible solution that uses 3 swaps is [0,0,0,0,0,1,1,1,1,1,1].


Note:

1 <= data.length <= 10^5
0 <= data[i] <= 1*/
class Solution {
    public int minSwaps(int[] data) {
        if (data == null || data.length==0) return 0;
        int count = 0;
        for (int i=0;i<data.length;i++) {
            if (data[i] == 1) count++;
        }
        if (count==1 || count==data.length) return 0;
        int start = 0, end = start+count-1;
        int sum = 0;
        for (int i=start;i<count;i++) {
            if (data[i] == 1) sum ++;
        }
        int min = count-sum;
        start++;
        end++;
        while (end <data.length) {
            sum = sum-data[start-1];
            sum = sum+data[end];
            min = Math.min(min,count-sum);
            start++;
            end++;
        }
        return min;
    }
}

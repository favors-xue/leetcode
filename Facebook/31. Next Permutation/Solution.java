/**
31. Next Permutation
Medium

2265

738

Favorite

Share
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

Accepted
280,579
Submissions
899,648
*/
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null|| nums.length ==0) {
            return ;
        }

        for (int i=nums.length-1;i>=1;i--) {
            if(nums[i]<=nums[i-1]) {
                continue;
            }
            for (int j=nums.length-1;j>=i;j--) {
                if (nums[j]>nums[i-1]) {
                    swap(nums, j, i-1);
                    reverse(nums, i, nums.length-1);
                    return;
                }
            }
        }
        reverse(nums, 0, nums.length-1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int start, int end) {
        while(start<=end) {
            swap(nums,start++,end--);
        }
    }
}

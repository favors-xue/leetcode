/**
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
class Solution {
    public int trap(int[] height) {
        if (height.length<3) return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int leftMax = height[0], rightMax = height[height.length-1];
        left[0] = 0;
        right[height.length-1] = 0;
        for (int i = 1; i<height.length;i++) {
            left[i] = leftMax;
            if (height[i]>leftMax)
                leftMax = height[i];
        }
        for (int j=height.length-2;j>=0;j--) {
            right[j] = rightMax;
            if (height[j]>rightMax)
                rightMax = height[j];
        }
        int result = 0;
        for (int i = 0;i<height.length;i++) {
            result += (Math.min(left[i],right[i])-height[i])>=0?Math.min(left[i],right[i])-height[i]:0;
        }
        return result;
    }

    public int trap2(int[] height) {
        if (height.length<3) return 0;
        int left = 0, right = height.length -1,leftMax = 0, rightMax = 0;
        int result = 0;
        while (left<right) {
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            result += leftMax<rightMax ? leftMax - height[left++] : rightMax - height[right--];
        }
        return result;
    }
}

/**
42. Trapping Rain Water
Hard

4586

80

Favorite

Share
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/
class Solution {
    public int trap(int[] height) {
        int result = 0;
        if (height == null || height.length ==0) return result;
        int start = 0, end = height.length-1,maxStart = 0,maxEnd = 0;
        while (start<end) {
            maxStart = Math.max(maxStart,height[start]);
            if (height[start]<maxStart) {
                result += maxStart-height[start];
            }
            maxEnd = Math.max(maxEnd,height[end]);
            if (height[end]<maxEnd) {
                result += maxEnd-height[end];
            }
            if (height[start]<=height[end]) {
                start++;
            }
            else {
                end --;
            }
        }
        return result;
    }
}

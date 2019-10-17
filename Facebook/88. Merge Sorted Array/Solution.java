/**
88. Merge Sorted Array
Easy

1346

3150

Favorite

Share
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,5,10,19,0,0,0], m = 4
nums2 = [4,6,11],       n = 3
1,5,10,19,4,6,11
i =0 ,j = 4,  1,5,10,19,4,6,11
i =1,j=4, 1,4,10,19,5,6,11
i =2, j=4 1,4,5,19,10,6,11
i =3,j=4 1,4,5,6,10,19,11,
i=4,j=4,1,4,5,6,10,11,19

 4,6,11,1,5,10,19,
 i = 0, j=3 1,6,11,4,5,10,19
 i=1,j=3,1,4,11,6,5,10,19
 i=2,j=3,1,4,


Output: [1,2,2,3,5,6]
Accepted
430,524
Submissions
1,160,867
*/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i=0;i<n;i++) {
            nums1[m+i] = nums2[i];
        }
        int i=0;j=0;
        while(i<m || j<n) {

        }
    }
}

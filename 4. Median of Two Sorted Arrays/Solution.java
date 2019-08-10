/**
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

You may assume nums1 and nums2 cannot be both empty.

Example 1:

nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:

nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length+nums2.length];
        int i = 0, j = 0, n = 0,m=0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                result[n++] = nums1[i++];
            }
            else {
                result[n++] = nums2[j++];
            }
        }
        while (i<nums1.length) {
            result[n++] = nums1[i++];
        }
        while (j<nums2.length) {
            result[n++] = nums2[j++];
        }
        if (n==1) return(double)result[0];
        if (n==2) return (double)(result[0]+result[1])/2;

        if (n % 2 == 0) {
            m = n/2;
            return (double)(result[m-1]+result[m])/2;
        }
        else {
            m = (n-1)/2;
            return (double)result[m];
        }

    }

    /**
     formular : partition x + partition y = (x + y + 1)/2
     found: maxLeft X <= minRight Y, minLeft X >= maxLeft Y
     if maxLeft X > minRight Y move towards left in X
     else move towards right in X
     if it is odd then avg(Max(maxLeftX, maxLeftY),Min(minRightX,minRightY ))
     else Max(maxLeftX,maxLeftY)
    */
    public double findMedianSortedArraysBinarySearch(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArraysBinarySearch(nums2,nums1);
        }
        int x = nums1.length, y = nums2.length;
        int low = 0, high = x;
        while (low <= high) {
            int partX = (low+high)/2;
            int partY = (x+y+1)/2-partX;
            int maxLeftX = (partX == 0)? Integer.MIN_VALUE : nums1[partX-1];
            int minRightX = (partX == x)? Integer.MAX_VALUE : nums1[partX];

            int maxLeftY = (partY ==0) ? Integer.MIN_VALUE : nums2[partY-1];
            int minRightY = (partY == y) ? Integer.MAX_VALUE : nums2[partY];

            if (maxLeftX<=minRightY && maxLeftY <=minRightX) {
                if ((x+y)%2==0) {
                    return (double)(Math.max(maxLeftX,maxLeftY)+Math.min(minRightX,minRightY))/2;
                }
                else {
                    return (double)Math.max(maxLeftX,maxLeftY);
                }
            }
            else if (maxLeftX > minRightY)
            {
                high = partX - 1;
            }
            else {
                low = partX +1;
            }
        }
        return -1;

    }
}

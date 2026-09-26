package com.solairerove.dsa.problems;

public class P0004_MedianOfTwoSortedArrays {

    // time O(log(min(m, n))), space O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int l = 0, r = m;
        while (l <= r) { // bs on smaller arr
            int i = (r + l) >>> 1;
            int j = (m + n + 1) / 2 - i; // half - mid
            int left1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = i < m ? nums1[i] : Integer.MAX_VALUE;
            int left2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = j < n ? nums2[j] : Integer.MAX_VALUE;
            if (left1 <= right2 && left2 <= right1) {
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        return -1;
    }
}

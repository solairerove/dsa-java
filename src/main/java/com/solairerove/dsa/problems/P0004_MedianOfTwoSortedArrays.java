package com.solairerove.dsa.problems;

public class P0004_MedianOfTwoSortedArrays {

    // time O(log(min(m, n))), space O(1)
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);

        int m = nums1.length, n = nums2.length;
        int total = m + n;
        int half = (total + 1) / 2;
        int l = 0, r = m;
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = half - i;

            int left1 = i > 0 ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = i < m ? nums1[i] : Integer.MAX_VALUE;
            int left2 = j > 0 ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = j < n ? nums2[j] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 != 0) {
                    return Math.max(left1, left2);
                }
                return ((long) Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {
                r = i - 1;
            } else {
                l = i + 1;
            }
        }

        throw new IllegalArgumentException("input not sorted");
    }
}

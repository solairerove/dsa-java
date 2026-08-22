package com.solairerove.dsa.problems;

public class P0088_MergeSortedArray {

    // time O(m + n), space O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int right1 = m - 1, right2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (right2 < 0) return;

            if (right1 >= 0 && nums1[right1] > nums2[right2]) nums1[i] = nums1[right1--];
            else nums1[i] = nums2[right2--];
        }
    }
}

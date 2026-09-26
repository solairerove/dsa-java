package com.solairerove.dsa.problems;

public class P0088_MergeSortedArray {

    // time O(m + n), space O(1)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int r1 = m - 1, r2 = n - 1;
        for (int i = m + n - 1; i >= 0; i--) {
            if (r2 < 0) {
                break;
            }

            if (r1 >= 0 && nums1[r1] > nums2[r2]) {
                nums1[i] = nums1[r1--];
            } else {
                nums1[i] = nums2[r2--];
            }
        }
    }
}

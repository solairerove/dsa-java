package com.solairerove.dsa.problems;

import java.util.Arrays;

public class P0912_SortAnArray {

    // time O(n * log(n)), space O(n)
    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1) {
            return nums;
        }

        int mid = nums.length / 2;
        int[] left = sortArray(Arrays.copyOfRange(nums, 0, mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] merged = new int[left.length + right.length];
        int l = 0, i = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (left[l] <= right[r]) {
                merged[i++] = left[l++];
            } else {
                merged[i++] = right[r++];
            }
        }

        while (l < left.length) {
            merged[i++] = left[l++];
        }

        while (r < right.length) {
            merged[i++] = right[r++];
        }

        return merged;
    }
}

package com.solairerove.dsa.problems;

import static com.solairerove.dsa.common.ArrayUtils.swap;

public class P0189_RotateArray {

    // time O(n), space O(1)
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private static void reverse(int[] nums, int l, int r) {
        while (l < r) {
            swap(nums, l++, r--);
        }
    }
}

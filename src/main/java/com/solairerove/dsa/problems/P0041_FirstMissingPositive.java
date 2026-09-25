package com.solairerove.dsa.problems;

import static com.solairerove.dsa.common.ArrayUtils.swap;

public class P0041_FirstMissingPositive {

    // time O(n), space O(1)
    public static int firstMissingPositiveCycleSort(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }

            int idx = nums[i] - 1;
            if (nums[i] != nums[idx]) {
                swap(nums, i, idx);
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}

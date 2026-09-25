package com.solairerove.dsa.problems;

import static com.solairerove.dsa.common.ArrayUtils.swap;

public class P0075_SortColors {

    // time O(n), space O(1)
    public static void sortColors(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] < 1) {
                swap(nums, l++, i++);
            } else if (nums[i] > 1) {
                swap(nums, i, r--);
            } else {
                i++;
            }
        }
    }
}

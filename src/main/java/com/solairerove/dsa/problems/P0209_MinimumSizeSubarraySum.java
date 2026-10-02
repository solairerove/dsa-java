package com.solairerove.dsa.problems;

public class P0209_MinimumSizeSubarraySum {

    // time O(n), space O(1)
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, window = 0, res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; r++) {
            window += nums[r];
            while (window >= target) {
                res = Math.min(res, r - l + 1);
                window -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

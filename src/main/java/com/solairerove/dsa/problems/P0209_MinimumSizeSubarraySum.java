package com.solairerove.dsa.problems;

public class P0209_MinimumSizeSubarraySum {

    // time O(n), space O(1)
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;
        while (true) {
            if (windowSum < target) {
                if (r == nums.length) break;
                windowSum += nums[r++];
            } else {
                res = Math.min(res, r - l);
                windowSum -= nums[l++];
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    // time O(n), space O(1)
    public static int minSubArrayLenShrink(int target, int[] nums) {
        int l = 0, r = 0;
        int windowSum = 0;
        int res = Integer.MAX_VALUE;
        while (r < nums.length) {
            windowSum += nums[r];
            while (windowSum >= target) {
                res = Math.min(res, r - l + 1);
                windowSum -= nums[l++];
            }
            r++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

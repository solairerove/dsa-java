package com.solairerove.dsa.problems;

public class P1004_MaxConsecutiveOnesIII {

    // time O(n), space O(1)
    public static int longestOnes(int[] nums, int k) {
        int l = 0, zeros = 0, res = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                zeros++;
            }

            if (zeros > k) {
                if (nums[l] == 0) {
                    zeros--;
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;
    }

    // time O(n), space O(1)
    public static int longestOnesCountingOnes(int[] nums, int k) {
        int n = nums.length;
        int l = 0, r = 0, ones = 0;
        int res = 0;
        while (r < n) {
            if (nums[r] == 1) {
                ones++;
            }

            while ((r - l + 1) - ones > k) {
                if (nums[l] == 1) {
                    ones--;
                }
                l++;
            }

            res = Math.max(res, r - l + 1);
            r++;
        }

        return res;
    }
}

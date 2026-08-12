package com.solairerove.dsa.problems;

public class P0238_ProductOfArrayExceptSelf {

    // time O(n), space O(n)
    public static int[] productExceptSelf(int[] nums) {
        // [1, 2, 4, 6]
        // keeping in head prefix product anyway, but write only excluding nums[i]
        // [1,] ps=1
        // [1,1] ps=2
        // [1,1,2] ps=8
        // [1,1,2,8] ps=36

        // [1, 2, 4, 6]
        // [1] ss=6
        // [6,1] ss=24
        // [24,6,1] ss=48
        // [48,24,6,1] ss=48
        int n = nums.length;
        int ps = 1;
        int[] prefixArr = new int[n];
        for (int i = 0; i < n; i++) {
            prefixArr[i] = ps;
            ps *= nums[i];
        }

        int ss = 1;
        int[] suffixArr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            suffixArr[i] = ss;
            ss *= nums[i];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefixArr[i] * suffixArr[i];
        }

        return res;
    }
}

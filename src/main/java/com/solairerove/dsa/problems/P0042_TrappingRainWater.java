package com.solairerove.dsa.problems;

public class P0042_TrappingRainWater {

    // time O(n), space O(n)
    public static int trapPrefixMax(int[] height) {
        int n = height.length;
        int[] pm = new int[n]; // prefix max
        int[] sm = new int[n]; // suffix max

        pm[0] = height[0];
        for (int i = 1; i < n; i++) {
            pm[i] = Math.max(pm[i - 1], height[i]);
        }

        sm[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            sm[i] = Math.max(sm[i + 1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            res += Math.min(pm[i], sm[i]) - height[i];
        }

        return res;
    }

    // time O(n), space O(1)
    public static int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }

        return res;
    }
}

package com.solairerove.dsa.problems;

public class P0011_ContainerWithMostWater {

    // time O(n), space O(1)
    public static int maxArea(int[] heights) {
        int l = 0, r = heights.length - 1;
        int res = 0;
        while (l < r) {
            int minHeight = Math.min(heights[l], heights[r]);
            int amountOfWater = minHeight * (r - l);
            res = Math.max(res, amountOfWater);

            while (l < r && heights[l] <= minHeight) l++;
            while (l < r && heights[r] <= minHeight) r--;
        }

        return res;
    }
}

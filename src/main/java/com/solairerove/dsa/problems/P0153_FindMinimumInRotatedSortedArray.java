package com.solairerove.dsa.problems;

public class P0153_FindMinimumInRotatedSortedArray {

    // time O(log n), space O(1)
    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l];
    }
}

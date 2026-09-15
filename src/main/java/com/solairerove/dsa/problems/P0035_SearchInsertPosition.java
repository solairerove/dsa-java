package com.solairerove.dsa.problems;

public class P0035_SearchInsertPosition {

    // time O(log n), space O(1)
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}

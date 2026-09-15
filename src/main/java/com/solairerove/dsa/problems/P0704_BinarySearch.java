package com.solairerove.dsa.problems;

public class P0704_BinarySearch {

    // time O(log n), space O(1)
    public static int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int guess = nums[mid];
            if (guess == target) {
                return mid;
            } else if (guess < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    // time O(log n), space O(1)
    public static int searchUpperBound(int[] nums, int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (nums[mid] > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (l > 0 && nums[l - 1] == target) {
            return l - 1;
        } else {
            return -1;
        }
    }
}

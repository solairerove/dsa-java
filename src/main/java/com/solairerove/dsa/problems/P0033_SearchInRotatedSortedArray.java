package com.solairerove.dsa.problems;

public class P0033_SearchInRotatedSortedArray {

    // time O(log n), space O(1)
    public static int search(int[] nums, int target) {
        int minIdx = findMinIdx(nums);
        int leftPart = bs(nums, 0, minIdx - 1, target);
        int rightPart = bs(nums, minIdx, nums.length - 1, target);

        return leftPart == -1 ? rightPart : leftPart;
    }

    private static int bs(int[] nums, int l, int r, int target) {
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

    private static int findMinIdx(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    // time O(log n), space O(1)
    public static int searchOnePass(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}

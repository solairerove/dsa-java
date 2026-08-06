package com.solairerove.dsa.problems;

public class P0075_SortColors {

    // time O(n), space O(1)
    public static void sortColors(int[] nums) {
        int l = 0, i = 0, r = nums.length - 1;
        while (i <= r) {
            if (nums[i] < 1) {
                swap(nums, l++, i++);
            } else if (nums[i] > 1) {
                swap(nums, i, r--);
            } else {
                i++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

package com.solairerove.dsa.problems;

public class P0912_SortAnArray {

    // time O(n * log(n)), space O(n)
    public static int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length, new int[nums.length]);

        return nums;
    }

    private static void sort(int[] arr, int l, int r, int[] temp) {
        if (r - l < 2) {
            return;
        }

        int mid = (l + r) >>> 1;
        sort(arr, l, mid, temp);
        sort(arr, mid, r, temp);
        merge(arr, l, mid, r, temp);
    }

    private static void merge(int[] arr, int l, int mid, int r, int[] temp) {
        System.arraycopy(arr, l, temp, l, r - l);

        int idx = l;
        int i = l, j = mid;
        while (i < mid && j < r) {
            if (temp[i] <= temp[j]) {
                arr[idx++] = temp[i++];
            } else {
                arr[idx++] = temp[j++];
            }
        }

        while (i < mid) {
            arr[idx++] = temp[i++];
        }

        while (j < r) {
            arr[idx++] = temp[j++];
        }
    }
}

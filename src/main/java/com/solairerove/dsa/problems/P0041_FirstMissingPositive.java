package com.solairerove.dsa.problems;

public class P0041_FirstMissingPositive {

    // time O(n), space O(1)
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= n) {
                if (nums[val - 1] > 0) {
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (n + 1);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] >= 0) {
                return i;
            }
        }

        return n + 1;
    }
    // time O(n), space O(1)
    public static int firstMissingPositiveCycleSort(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] <= 0 || nums[i] > n) {
                i++;
                continue;
            }
            int idx = nums[i] - 1;
            if (nums[i] != nums[idx]) {
                int tmp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = tmp;
            } else {
                i++;
            }
        }

        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}

package com.solairerove.dsa.problems;

public class P0410_SplitArrayLargestSum {

    // time O(n * log(sum(nums))), space O(1)
    public static int splitArray(int[] nums, int k) {
        // res is in [max(nums)..sum(nums)]
        int max = 0, sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int l = max, r = sum;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (subarraysNeeded(nums, mid) > k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private static int subarraysNeeded(int[] nums, int capacity) {
        int load = 0, subarrays = 1;
        for (int num : nums) {
            if (load + num > capacity) {
                load = num;
                subarrays++;
            } else {
                load += num;
            }
        }

        return subarrays;
    }
}

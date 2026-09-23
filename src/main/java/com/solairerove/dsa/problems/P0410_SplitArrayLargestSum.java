package com.solairerove.dsa.problems;

public class P0410_SplitArrayLargestSum {

    // time O(n * log(sum(nums))), space O(1)
    public static int splitArray(int[] nums, int k) {
        // res is in [max(nums)..sum(nums)]
        int maxNum = 0, sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }

        int l = maxNum, r = sum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (subarraysNeeded(nums, mid) > k) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }

    private static int subarraysNeeded(int[] nums, int capacity) {
        int currSum = 0, subarrays = 1;
        for (int num : nums) {
            if (currSum + num > capacity) {
                subarrays++;
                currSum = num;
            } else {
                currSum += num;
            }
        }

        return subarrays;
    }
}

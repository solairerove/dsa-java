package com.solairerove.dsa.problems;

public class P0167_TwoSumIIInputArrayIsSorted {

    // time O(n), space O(1)
    public static int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int guess = numbers[l] + numbers[r];
            if (guess == target) return new int[]{l + 1, r + 1};
            if (guess < target) l++;
            else r--;
        }

        return new int[]{};
    }

    // time O(n * log n), space O(1)
    public static int[] twoSumBinarySearch(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            int l = i + 1, r = n - 1;
            int guess = target - numbers[i];
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (numbers[mid] == guess) return new int[]{i + 1, mid + 1};
                else if (numbers[mid] < guess) l = mid + 1;
                else r = mid - 1;
            }
        }

        return new int[]{};
    }
}

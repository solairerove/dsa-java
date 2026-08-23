package com.solairerove.dsa.problems;

public class P0167_TwoSumIIInputArrayIsSorted {

    // time O(n), space O(1)
    public static int[] twoSumNaive(int[] numbers, int target) {
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
}

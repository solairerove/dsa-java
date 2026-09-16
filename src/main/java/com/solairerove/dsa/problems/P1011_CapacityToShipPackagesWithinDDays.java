package com.solairerove.dsa.problems;

public class P1011_CapacityToShipPackagesWithinDDays {

    // time O(n * log(sum(weights))), space O(1)
    public static int shipWithinDays(int[] weights, int days) {
        int maxWeight = 0, weightsSum = 0;
        for (int weight : weights) {
            weightsSum += weight;
            maxWeight = Math.max(maxWeight, weight);
        }

        int l = maxWeight, r = weightsSum;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (daysNeed(weights, mid) <= days) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    private static int daysNeed(int[] weights, int capacity) {
        int days = 1, load = 0;
        for (int weight : weights) {
            if (load + weight > capacity) {
                days++;
                load = weight;
            } else {
                load += weight;
            }
        }

        return days;
    }
}

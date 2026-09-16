package com.solairerove.dsa.problems;

public class P1011_CapacityToShipPackagesWithinDDays {

    // time O(n * log(sum(weights))), space O(1)
    public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int maxWeight = weights[0];
        int weightsSum = weights[0];
        for (int i = 1; i < n; i++) {
            int currWeight = weights[i];
            weightsSum += currWeight;
            if (currWeight > maxWeight) {
                maxWeight = currWeight;
            }
        }

        int l = maxWeight, r = weightsSum;
        while (l < r) {
            int leastWeightCapacity = l + (r - l) / 2;
            int pickDays = 1;
            int currWeight = 0;
            for (int weight : weights) {
                if (currWeight + weight > leastWeightCapacity) {
                    currWeight = weight;
                    pickDays++;
                } else {
                    currWeight += weight;
                }
            }

            if (pickDays <= days) {
                r = leastWeightCapacity;
            } else {
                l = leastWeightCapacity + 1;
            }
        }

        return l;
    }
}

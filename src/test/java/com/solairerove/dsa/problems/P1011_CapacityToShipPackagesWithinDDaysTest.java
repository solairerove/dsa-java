package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.solairerove.dsa.problems.P1011_CapacityToShipPackagesWithinDDays.shipWithinDays;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P1011_CapacityToShipPackagesWithinDDaysTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(15, shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(6, shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(3, shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));
    }

    @Test
    void singlePackage() {
        assertEquals(5, shipWithinDays(new int[]{5}, 1));
    }

    @Test
    void oneDayNeedsFullSum() {
        assertEquals(15, shipWithinDays(new int[]{1, 2, 3, 4, 5}, 1));
    }

    @Test
    void oneDayPerPackageNeedsMaxWeight() {
        assertEquals(5, shipWithinDays(new int[]{1, 2, 3, 4, 5}, 5));
    }

    @Test
    void moreDaysThanPackages() {
        assertEquals(5, shipWithinDays(new int[]{1, 2, 3, 4, 5}, 10));
    }

    @Test
    void allWeightsEqual() {
        assertEquals(2, shipWithinDays(new int[]{1, 1, 1, 1}, 2));
        assertEquals(1, shipWithinDays(new int[]{1, 1, 1, 1}, 4));
    }

    @Test
    void heavyPackageDominates() {
        assertEquals(100, shipWithinDays(new int[]{1, 1, 100, 1, 1}, 4));
    }

    @Test
    void maxWeightValues() {
        assertEquals(500, shipWithinDays(new int[]{500, 500, 500}, 3));
        assertEquals(1_000, shipWithinDays(new int[]{500, 500, 500}, 2));
        assertEquals(1_500, shipWithinDays(new int[]{500, 500, 500}, 1));
    }

    @Test
    void manyPackages() {
        int[] weights = new int[50_000];
        Arrays.fill(weights, 500);
        assertEquals(500, shipWithinDays(weights, 50_000));
    }

    @Test
    void matchesBruteForceOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 1_000; t++) {
            int n = random.nextInt(1, 10);
            int[] weights = random.ints(n, 1, 20).toArray();
            int days = random.nextInt(1, n + 1);

            assertEquals(bruteForce(weights, days), shipWithinDays(weights, days));
        }
    }

    // smallest capacity that ships in time, found by trying every capacity in order
    private static int bruteForce(int[] weights, int days) {
        int max = Arrays.stream(weights).max().orElseThrow();
        int sum = Arrays.stream(weights).sum();
        for (int capacity = max; capacity <= sum; capacity++) {
            if (daysNeeded(weights, capacity) <= days) {
                return capacity;
            }
        }

        return sum;
    }

    // greedy: fill the current day until the next package does not fit, then start a new day
    private static int daysNeeded(int[] weights, int capacity) {
        int days = 1;
        int load = 0;
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

package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0853_CarFleet.carFleet;
import static com.solairerove.dsa.problems.P0853_CarFleet.carFleetBucket;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0853_CarFleetTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(3, carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(1, carFleet(10, new int[]{3}, new int[]{3}));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(1, carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}));
    }

    @Test
    void noCars() {
        assertEquals(0, carFleet(10, new int[]{}, new int[]{}));
    }

    @Test
    void carStartingAtTarget() {
        assertEquals(1, carFleet(10, new int[]{10}, new int[]{5}));
    }

    @Test
    void sameSpeedNeverCatchUp() {
        assertEquals(3, carFleet(10, new int[]{0, 2, 4}, new int[]{1, 1, 1}));
    }

    @Test
    void equalArrivalTimesMerge() {
        assertEquals(1, carFleet(10, new int[]{0, 5}, new int[]{2, 1}));
    }

    @Test
    void fasterCarBehindCatchesUp() {
        assertEquals(1, carFleet(10, new int[]{0, 5}, new int[]{10, 1}));
    }

    @Test
    void slowerCarBehindNeverCatchesUp() {
        assertEquals(2, carFleet(10, new int[]{0, 5}, new int[]{1, 10}));
    }

    @Test
    void chainMergesIntoSingleFleet() {
        assertEquals(1, carFleet(10, new int[]{0, 1, 2}, new int[]{3, 2, 1}));
    }

    @Test
    void twoSeparateFleets() {
        assertEquals(2, carFleet(20, new int[]{0, 10}, new int[]{1, 1}));
    }

    @Test
    void unsortedInputPositions() {
        assertEquals(3, carFleet(20, new int[]{10, 0, 15}, new int[]{1, 1, 1000}));
    }

    @Test
    void allCarsAtSameSpeedDecreasingPositions() {
        assertEquals(4, carFleet(100, new int[]{9, 6, 3, 0}, new int[]{5, 5, 5, 5}));
    }

    @Test
    void leadCarSlowestSwallowsEveryone() {
        assertEquals(1, carFleet(50, new int[]{0, 10, 20, 30}, new int[]{100, 100, 100, 1}));
    }

    @Test
    void bucketLeetcodeExampleOne() {
        assertEquals(3, carFleetBucket(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
    }

    @Test
    void bucketLeetcodeExampleTwo() {
        assertEquals(1, carFleetBucket(10, new int[]{3}, new int[]{3}));
    }

    @Test
    void bucketLeetcodeExampleThree() {
        assertEquals(1, carFleetBucket(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}));
    }

    @Test
    void bucketNoCars() {
        assertEquals(0, carFleetBucket(10, new int[]{}, new int[]{}));
    }

    @Test
    void bucketSameSpeedNeverCatchUp() {
        assertEquals(3, carFleetBucket(10, new int[]{0, 2, 4}, new int[]{1, 1, 1}));
    }

    @Test
    void bucketEqualArrivalTimesMerge() {
        assertEquals(1, carFleetBucket(10, new int[]{0, 5}, new int[]{2, 1}));
    }

    @Test
    void bucketFasterCarBehindCatchesUp() {
        assertEquals(1, carFleetBucket(10, new int[]{0, 5}, new int[]{10, 1}));
    }

    @Test
    void bucketSlowerCarBehindNeverCatchesUp() {
        assertEquals(2, carFleetBucket(10, new int[]{0, 5}, new int[]{1, 10}));
    }

    @Test
    void bucketChainMergesIntoSingleFleet() {
        assertEquals(1, carFleetBucket(10, new int[]{0, 1, 2}, new int[]{3, 2, 1}));
    }

    @Test
    void bucketTwoSeparateFleets() {
        assertEquals(2, carFleetBucket(20, new int[]{0, 10}, new int[]{1, 1}));
    }

    @Test
    void bucketUnsortedInputPositions() {
        assertEquals(3, carFleetBucket(20, new int[]{10, 0, 15}, new int[]{1, 1, 1000}));
    }

    @Test
    void bucketAllCarsAtSameSpeedDecreasingPositions() {
        assertEquals(4, carFleetBucket(100, new int[]{9, 6, 3, 0}, new int[]{5, 5, 5, 5}));
    }

    @Test
    void bucketLeadCarSlowestSwallowsEveryone() {
        assertEquals(1, carFleetBucket(50, new int[]{0, 10, 20, 30}, new int[]{100, 100, 100, 1}));
    }
}

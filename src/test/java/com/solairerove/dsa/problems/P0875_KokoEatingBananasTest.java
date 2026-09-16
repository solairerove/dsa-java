package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.solairerove.dsa.problems.P0875_KokoEatingBananas.minEatingSpeed;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0875_KokoEatingBananasTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(4, minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(30, minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(23, minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
    }

    @Test
    void commentExample() {
        assertEquals(2, minEatingSpeed(new int[]{1, 4, 3, 2}, 9));
    }

    @Test
    void singlePileExactHours() {
        assertEquals(1, minEatingSpeed(new int[]{10}, 10));
    }

    @Test
    void singlePileOneHour() {
        assertEquals(10, minEatingSpeed(new int[]{10}, 1));
    }

    @Test
    void hoursEqualPileCountForcesMaxPile() {
        assertEquals(7, minEatingSpeed(new int[]{3, 6, 7, 5}, 4));
    }

    @Test
    void plentyOfHoursGivesSpeedOne() {
        assertEquals(1, minEatingSpeed(new int[]{3, 6, 7, 11}, 27));
        assertEquals(1, minEatingSpeed(new int[]{3, 6, 7, 11}, 1_000));
    }

    @Test
    void allPilesEqual() {
        assertEquals(2, minEatingSpeed(new int[]{4, 4, 4, 4}, 8));
        assertEquals(4, minEatingSpeed(new int[]{4, 4, 4, 4}, 4));
    }

    @Test
    void allOnes() {
        assertEquals(1, minEatingSpeed(new int[]{1, 1, 1, 1}, 4));
        assertEquals(1, minEatingSpeed(new int[]{1, 1, 1, 1}, 100));
    }

    @Test
    void ceilingRoundingMatters() {
        // speed 2 needs 3 + 3 = 6 hours, speed 3 needs 2 + 2 = 4 hours
        assertEquals(3, minEatingSpeed(new int[]{5, 5}, 4));
        assertEquals(2, minEatingSpeed(new int[]{5, 5}, 6));
    }

    @Test
    void largePileValues() {
        assertEquals(1_000_000_000, minEatingSpeed(new int[]{1_000_000_000}, 1));
        assertEquals(500_000_000, minEatingSpeed(new int[]{1_000_000_000}, 2));
        assertEquals(1, minEatingSpeed(new int[]{1_000_000_000}, 1_000_000_000));
    }

    @Test
    void manyLargePiles() {
        int[] piles = new int[10_000];
        Arrays.fill(piles, 1_000_000_000);
        assertEquals(10_000, minEatingSpeed(piles, 1_000_000_000));
    }

    @Test
    void matchesBruteForceOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 1_000; t++) {
            int n = random.nextInt(1, 10);
            int[] piles = random.ints(n, 1, 40).toArray();
            int h = random.nextInt(n, n + 60);

            assertEquals(bruteForce(piles, h), minEatingSpeed(piles, h));
        }
    }

    // smallest speed that finishes in time, found by trying every speed in order
    private static int bruteForce(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().orElseThrow();
        for (int k = 1; k <= maxPile; k++) {
            long hours = 0;
            for (int pile : piles) {
                hours += (pile + k - 1) / k;
            }

            if (hours <= h) {
                return k;
            }
        }

        return maxPile;
    }
}

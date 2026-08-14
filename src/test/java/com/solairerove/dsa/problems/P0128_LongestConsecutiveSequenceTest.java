package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0128_LongestConsecutiveSequenceTest {

    @Test
    void longestConsecutive_example1() {
        assertEquals(4, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    @Test
    void longestConsecutive_example2() {
        assertEquals(9, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }

    @Test
    void longestConsecutive_example3() {
        assertEquals(3, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{1, 0, 1, 2}));
    }

    @Test
    void longestConsecutive_emptyArray() {
        assertEquals(0, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{}));
    }

    @Test
    void longestConsecutive_singleElement() {
        assertEquals(1, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{42}));
    }

    @Test
    void longestConsecutive_allDuplicates() {
        assertEquals(1, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{7, 7, 7, 7}));
    }

    @Test
    void longestConsecutive_noConsecutivePairs() {
        assertEquals(1, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{10, 30, 20, 50}));
    }

    @Test
    void longestConsecutive_alreadySorted() {
        assertEquals(6, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    void longestConsecutive_reverseSorted() {
        assertEquals(6, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{6, 5, 4, 3, 2, 1}));
    }

    @Test
    void longestConsecutive_mergesTwoRunsViaMiddleValue() {
        assertEquals(7, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{1, 2, 3, 5, 6, 7, 4}));
    }

    @Test
    void longestConsecutive_mergeArrivesLast() {
        assertEquals(5, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{1, 2, 4, 5, 3}));
    }

    @Test
    void longestConsecutive_negativeAndPositiveSpanningZero() {
        assertEquals(5, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{-2, -1, 0, 1, 2}));
    }

    @Test
    void longestConsecutive_allNegative() {
        assertEquals(4, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{-5, -3, -4, -6, -1}));
    }

    @Test
    void longestConsecutive_twoEqualLengthRuns() {
        assertEquals(3, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{1, 2, 3, 10, 11, 12}));
    }

    @Test
    void longestConsecutive_longestRunIsNotTheFirstSeen() {
        assertEquals(4, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{9, 1, 50, 2, 3, 4}));
    }

    // LeetCode constrains values to [-10^9, 10^9]; Integer.MIN_VALUE/MAX_VALUE
    // would wrap on the num + 1 / num - 1 lookups
    @Test
    void longestConsecutive_constraintBoundaryValues() {
        assertEquals(2, P0128_LongestConsecutiveSequence.longestConsecutive(
                new int[]{-1_000_000_000, -999_999_999, 1_000_000_000}));
    }

    @Test
    void longestConsecutive_duplicatesInsideRun() {
        assertEquals(4, P0128_LongestConsecutiveSequence.longestConsecutive(new int[]{1, 2, 2, 3, 3, 3, 4}));
    }

    @Test
    void longestConsecutive_matchesBruteForceOnRandomInput() {
        Random random = new Random(128);
        for (int t = 0; t < 300; t++) {
            int[] nums = new int[random.nextInt(25)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(20) - 10;
            }

            assertEquals(bruteForce(nums), P0128_LongestConsecutiveSequence.longestConsecutive(nums));
        }
    }

    private static int bruteForce(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int best = 1, current = 1;
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] == sorted[i - 1]) {
                continue;
            }

            current = sorted[i] == sorted[i - 1] + 1 ? current + 1 : 1;
            best = Math.max(best, current);
        }

        return best;
    }
}

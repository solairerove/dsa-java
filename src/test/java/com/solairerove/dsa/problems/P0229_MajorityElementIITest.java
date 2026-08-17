package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0229_MajorityElementIITest {

    private static List<Integer> sorted(int[] nums) {
        List<Integer> res = new ArrayList<>(P0229_MajorityElementII.majorityElement(nums));
        res.sort(null);

        return res;
    }

    private static List<Integer> bruteForce(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.merge(num, 1, Integer::sum);
        }

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > nums.length / 3) {
                res.add(entry.getKey());
            }
        }
        res.sort(null);

        return res;
    }

    @Test
    void majorityElement_example1() {
        assertEquals(List.of(3), sorted(new int[]{3, 2, 3}));
    }

    @Test
    void majorityElement_example2() {
        assertEquals(List.of(1), sorted(new int[]{1}));
    }

    @Test
    void majorityElement_example3() {
        assertEquals(List.of(1, 2), sorted(new int[]{1, 2}));
    }

    @Test
    void majorityElement_twoMajorities() {
        assertEquals(List.of(1, 2), sorted(new int[]{1, 1, 1, 2, 2, 2, 3}));
    }

    @Test
    void majorityElement_noMajority() {
        assertEquals(List.of(), sorted(new int[]{1, 2, 3, 4, 5, 6}));
    }

    @Test
    void majorityElement_allSame() {
        assertEquals(List.of(7), sorted(new int[]{7, 7, 7, 7}));
    }

    @Test
    void majorityElement_exactlyOneThirdIsExcluded() {
        assertEquals(List.of(), sorted(new int[]{1, 1, 2, 2, 3, 3}));
    }

    @Test
    void majorityElement_negativeOneAsElement() {
        assertEquals(List.of(-1), sorted(new int[]{-1}));
    }

    @Test
    void majorityElement_negativeOneAsMajority() {
        assertEquals(List.of(-1), sorted(new int[]{-1, -1, -1, 2, 3}));
    }

    @Test
    void majorityElement_negativeOneAndOtherMajority() {
        assertEquals(List.of(-1, 2), sorted(new int[]{-1, -1, 2, 2}));
    }

    @Test
    void majorityElement_allNegative() {
        assertEquals(List.of(-5), sorted(new int[]{-5, -5, -5, -7, -9}));
    }

    @Test
    void majorityElement_zeros() {
        assertEquals(List.of(0), sorted(new int[]{0, 0, 0, 1, 2}));
    }

    @Test
    void majorityElement_boundaryValues() {
        assertEquals(List.of(Integer.MIN_VALUE, Integer.MAX_VALUE),
                sorted(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }

    @Test
    void majorityElement_candidatesAtEndOfArray() {
        assertEquals(List.of(4, 5), sorted(new int[]{1, 4, 4, 5, 5}));
    }

    @Test
    void majorityElement_neverReturnsMoreThanTwo() {
        Random random = new Random(229);
        for (int t = 0; t < 100; t++) {
            int[] nums = new int[1 + random.nextInt(30)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(5);
            }

            assertTrue(P0229_MajorityElementII.majorityElement(nums).size() <= 2);
        }
    }

    @Test
    void majorityElement_doesNotMutateInput() {
        int[] nums = {3, 2, 3};
        P0229_MajorityElementII.majorityElement(nums);

        assertEquals(3, nums[0]);
        assertEquals(2, nums[1]);
        assertEquals(3, nums[2]);
    }

    @Test
    void majorityElement_matchesBruteForceOnSmallRandomInput() {
        Random random = new Random(2291);
        for (int t = 0; t < 500; t++) {
            int[] nums = new int[1 + random.nextInt(12)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(4) - 1;
            }

            assertEquals(bruteForce(nums), sorted(nums));
        }
    }

    @Test
    void majorityElement_matchesBruteForceOnLargeRandomInput() {
        Random random = new Random(2292);
        for (int t = 0; t < 100; t++) {
            int[] nums = new int[1 + random.nextInt(300)];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = random.nextInt(20) - 10;
            }

            assertEquals(bruteForce(nums), sorted(nums));
        }
    }
}

package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0347_TopKFrequentElementsTest {

    @Test
    void topKFrequentNaive_example1() {
        assertArrayEquals(new int[]{1, 2}, P0347_TopKFrequentElements.topKFrequentNaive(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    @Test
    void topKFrequentNaive_example2() {
        assertArrayEquals(new int[]{1}, P0347_TopKFrequentElements.topKFrequentNaive(new int[]{1}, 1));
    }

    @Test
    void topKFrequentNaive_singleElementRepeated() {
        assertArrayEquals(new int[]{5}, P0347_TopKFrequentElements.topKFrequentNaive(new int[]{5, 5, 5, 5}, 1));
    }

    @Test
    void topKFrequentNaive_kEqualsDistinctCount() {
        int[] res = P0347_TopKFrequentElements.topKFrequentNaive(new int[]{1, 1, 2, 2, 3}, 3);
        assertEquals(Set.of(1, 2, 3), Arrays.stream(res).boxed().collect(java.util.stream.Collectors.toSet()));
        assertEquals(3, res[2]);
    }

    @Test
    void topKFrequentNaive_negativeNumbers() {
        assertArrayEquals(new int[]{-1, 2}, P0347_TopKFrequentElements.topKFrequentNaive(new int[]{-1, -1, -1, 2, 2, 3}, 2));
    }

    @Test
    void topKFrequentNaive_allDistinctTakeOne() {
        int[] res = P0347_TopKFrequentElements.topKFrequentNaive(new int[]{4, 7, 9}, 1);
        assertEquals(1, res.length);
        assertEquals(Set.of(4, 7, 9).contains(res[0]), true);
    }

    @Test
    void topKFrequentNaive_ordersByDescendingFrequency() {
        assertArrayEquals(new int[]{3, 2, 1},
                P0347_TopKFrequentElements.topKFrequentNaive(new int[]{1, 2, 2, 3, 3, 3}, 3));
    }

    @Test
    void topKFrequentNaive_largeInput() {
        int[] nums = new int[3000];
        for (int i = 0; i < 1500; i++) {
            nums[i] = 8;
        }
        for (int i = 1500; i < 2500; i++) {
            nums[i] = 9;
        }
        for (int i = 2500; i < 3000; i++) {
            nums[i] = 10;
        }

        assertArrayEquals(new int[]{8, 9}, P0347_TopKFrequentElements.topKFrequentNaive(nums, 2));
    }
}

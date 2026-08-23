package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0347_TopKFrequentElementsTest {

    @Test
    void topKFrequent_example1() {
        assertArrayEquals(new int[]{1, 2}, P0347_TopKFrequentElements.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
    }

    @Test
    void topKFrequent_example2() {
        assertArrayEquals(new int[]{1}, P0347_TopKFrequentElements.topKFrequent(new int[]{1}, 1));
    }

    @Test
    void topKFrequent_singleElementRepeated() {
        assertArrayEquals(new int[]{5}, P0347_TopKFrequentElements.topKFrequent(new int[]{5, 5, 5, 5}, 1));
    }

    @Test
    void topKFrequent_kEqualsDistinctCount() {
        assertEquals(Set.of(1, 2, 3), asSet(P0347_TopKFrequentElements.topKFrequent(new int[]{1, 1, 2, 2, 3}, 3)));
    }

    @Test
    void topKFrequent_negativeNumbers() {
        assertArrayEquals(new int[]{-1, 2}, P0347_TopKFrequentElements.topKFrequent(new int[]{-1, -1, -1, 2, 2, 3}, 2));
    }

    @Test
    void topKFrequent_allDistinctTakeOne() {
        int[] res = P0347_TopKFrequentElements.topKFrequent(new int[]{4, 7, 9}, 1);
        assertEquals(1, res.length);
        assertTrue(Set.of(4, 7, 9).contains(res[0]));
    }

    @Test
    void topKFrequent_ordersByDescendingFrequency() {
        assertArrayEquals(new int[]{3, 2, 1}, P0347_TopKFrequentElements.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 3));
    }

    @Test
    void topKFrequent_stopsAtK() {
        assertArrayEquals(new int[]{3, 2}, P0347_TopKFrequentElements.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2));
    }

    @Test
    void topKFrequent_largeInput() {
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

        assertArrayEquals(new int[]{8, 9}, P0347_TopKFrequentElements.topKFrequent(nums, 2));
    }

    private static Set<Integer> asSet(int[] nums) {
        return Arrays.stream(nums).boxed().collect(java.util.stream.Collectors.toSet());
    }

    @Test
    void topKFrequentHeap_example1() {
        assertEquals(Set.of(1, 2), asSet(P0347_TopKFrequentElements.topKFrequentHeap(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    @Test
    void topKFrequentHeap_example2() {
        assertArrayEquals(new int[]{1}, P0347_TopKFrequentElements.topKFrequentHeap(new int[]{1}, 1));
    }

    @Test
    void topKFrequentHeap_singleElementRepeated() {
        assertArrayEquals(new int[]{5}, P0347_TopKFrequentElements.topKFrequentHeap(new int[]{5, 5, 5, 5}, 1));
    }

    @Test
    void topKFrequentHeap_kEqualsDistinctCount() {
        assertEquals(Set.of(1, 2, 3), asSet(P0347_TopKFrequentElements.topKFrequentHeap(new int[]{1, 1, 2, 2, 3}, 3)));
    }

    @Test
    void topKFrequentHeap_negativeNumbers() {
        assertEquals(Set.of(-1, 2), asSet(P0347_TopKFrequentElements.topKFrequentHeap(new int[]{-1, -1, -1, 2, 2, 3}, 2)));
    }

    @Test
    void topKFrequentHeap_allDistinctTakeOne() {
        int[] res = P0347_TopKFrequentElements.topKFrequentHeap(new int[]{4, 7, 9}, 1);
        assertEquals(1, res.length);
        assertTrue(Set.of(4, 7, 9).contains(res[0]));
    }

    @Test
    void topKFrequentHeap_dropsLowestFrequency() {
        assertEquals(Set.of(3, 2), asSet(P0347_TopKFrequentElements.topKFrequentHeap(new int[]{1, 2, 2, 3, 3, 3}, 2)));
    }

    @Test
    void topKFrequentHeap_largeInput() {
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

        assertEquals(Set.of(8, 9), asSet(P0347_TopKFrequentElements.topKFrequentHeap(nums, 2)));
    }

    @Test
    void topKFrequentQuickSelect_example1() {
        assertEquals(Set.of(1, 2), asSet(P0347_TopKFrequentElements.topKFrequentQuickSelect(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }

    @Test
    void topKFrequentQuickSelect_example2() {
        assertArrayEquals(new int[]{1}, P0347_TopKFrequentElements.topKFrequentQuickSelect(new int[]{1}, 1));
    }

    @Test
    void topKFrequentQuickSelect_singleElementRepeated() {
        assertArrayEquals(new int[]{5}, P0347_TopKFrequentElements.topKFrequentQuickSelect(new int[]{5, 5, 5, 5}, 1));
    }

    @Test
    void topKFrequentQuickSelect_kEqualsDistinctCount() {
        assertEquals(Set.of(1, 2, 3), asSet(P0347_TopKFrequentElements.topKFrequentQuickSelect(new int[]{1, 1, 2, 2, 3}, 3)));
    }

    @Test
    void topKFrequentQuickSelect_negativeNumbers() {
        assertEquals(Set.of(-1, 2), asSet(P0347_TopKFrequentElements.topKFrequentQuickSelect(new int[]{-1, -1, -1, 2, 2, 3}, 2)));
    }

    @Test
    void topKFrequentQuickSelect_allDistinctTakeOne() {
        int[] res = P0347_TopKFrequentElements.topKFrequentQuickSelect(new int[]{4, 7, 9}, 1);
        assertEquals(1, res.length);
        assertTrue(Set.of(4, 7, 9).contains(res[0]));
    }

    @Test
    void topKFrequentQuickSelect_dropsLowestFrequency() {
        assertEquals(Set.of(3, 2), asSet(P0347_TopKFrequentElements.topKFrequentQuickSelect(new int[]{1, 2, 2, 3, 3, 3}, 2)));
    }

    @Test
    void topKFrequentQuickSelect_largeInput() {
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

        assertEquals(Set.of(8, 9), asSet(P0347_TopKFrequentElements.topKFrequentQuickSelect(nums, 2)));
    }

    @Test
    void topKFrequentQuickSelect_matchesBucketSort() {
        int[] nums = {5, 5, 5, 4, 4, 4, 3, 3, 2, 2, 1, 0, 0, 0, 0};
        assertEquals(asSet(P0347_TopKFrequentElements.topKFrequent(nums, 3)),
                asSet(P0347_TopKFrequentElements.topKFrequentQuickSelect(nums, 3)));
    }
}

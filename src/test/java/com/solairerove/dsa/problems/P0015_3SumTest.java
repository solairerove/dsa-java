package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.solairerove.dsa.problems.P0015_3Sum.threeSumNaive;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0015_3SumTest {

    @Test
    void shouldSolveExampleOneNaive() {
        assertEquals(Set.of(List.of(-1, -1, 2), List.of(-1, 0, 1)),
                asSet(threeSumNaive(new int[]{-1, 0, 1, 2, -1, -4})));
    }

    @Test
    void shouldReturnEmptyForExampleTwoNaive() {
        assertTrue(threeSumNaive(new int[]{0, 1, 1}).isEmpty());
    }

    @Test
    void shouldSolveExampleThreeNaive() {
        assertEquals(Set.of(List.of(0, 0, 0)), asSet(threeSumNaive(new int[]{0, 0, 0})));
    }

    @Test
    void shouldHandleEmptyArrayNaive() {
        assertTrue(threeSumNaive(new int[]{}).isEmpty());
    }

    @Test
    void shouldHandleTooFewElementsNaive() {
        assertTrue(threeSumNaive(new int[]{1, -1}).isEmpty());
    }

    @Test
    void shouldHandleAllPositivesNaive() {
        assertTrue(threeSumNaive(new int[]{1, 2, 3, 4}).isEmpty());
    }

    @Test
    void shouldHandleAllNegativesNaive() {
        assertTrue(threeSumNaive(new int[]{-1, -2, -3, -4}).isEmpty());
    }

    @Test
    void shouldDeduplicateRepeatedTripletsNaive() {
        assertEquals(Set.of(List.of(-1, 0, 1)), asSet(threeSumNaive(new int[]{-1, 0, 1, -1, 0, 1})));
    }

    @Test
    void shouldHandleManyZerosNaive() {
        assertEquals(Set.of(List.of(0, 0, 0)), asSet(threeSumNaive(new int[]{0, 0, 0, 0})));
    }

    @Test
    void shouldFindMultipleDistinctTripletsNaive() {
        assertEquals(Set.of(List.of(-4, -2, 6), List.of(-4, 0, 4), List.of(-4, 1, 3),
                        List.of(-4, 2, 2), List.of(-2, -2, 4), List.of(-2, 0, 2)),
                asSet(threeSumNaive(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6})));
    }

    @Test
    void shouldHandleSymmetricArrayNaive() {
        assertEquals(Set.of(List.of(-2, 0, 2), List.of(-1, 0, 1), List.of(-2, -1, 3)),
                asSet(threeSumNaive(new int[]{-2, -1, 0, 1, 2, 3})));
    }

    @Test
    void shouldReturnSortedTripletsNaive() {
        for (List<Integer> triplet : threeSumNaive(new int[]{-1, 0, 1, 2, -1, -4})) {
            assertEquals(3, triplet.size());
            assertTrue(triplet.get(0) <= triplet.get(1) && triplet.get(1) <= triplet.get(2));
            assertEquals(0, triplet.get(0) + triplet.get(1) + triplet.get(2));
        }
    }

    private static Set<List<Integer>> asSet(List<List<Integer>> res) {
        return new HashSet<>(res);
    }
}

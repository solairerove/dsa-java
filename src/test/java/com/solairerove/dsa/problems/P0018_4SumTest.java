package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.solairerove.dsa.problems.P0018_4Sum.fourSum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0018_4SumTest {

    @Test
    void shouldSolveExampleOne() {
        assertEquals(Set.of(List.of(-2, -1, 1, 2), List.of(-2, 0, 0, 2), List.of(-1, 0, 0, 1)),
                asSet(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)));
    }

    @Test
    void shouldSolveExampleTwo() {
        assertEquals(Set.of(List.of(2, 2, 2, 2)), asSet(fourSum(new int[]{2, 2, 2, 2, 2}, 8)));
    }

    @Test
    void shouldHandleEmptyArray() {
        assertTrue(fourSum(new int[]{}, 0).isEmpty());
    }

    @Test
    void shouldHandleFewerThanFourElements() {
        assertTrue(fourSum(new int[]{1, 2, 3}, 6).isEmpty());
    }

    @Test
    void shouldHandleExactlyFourElements() {
        assertEquals(Set.of(List.of(1, 2, 3, 4)), asSet(fourSum(new int[]{4, 1, 3, 2}, 10)));
    }

    @Test
    void shouldHandleAllZeros() {
        assertEquals(Set.of(List.of(0, 0, 0, 0)), asSet(fourSum(new int[]{0, 0, 0, 0, 0}, 0)));
    }

    @Test
    void shouldHandleNegativeTarget() {
        assertEquals(Set.of(List.of(-5, -4, -3, -2)), asSet(fourSum(new int[]{-5, -4, -3, -2}, -14)));
    }

    @Test
    void shouldReturnEmptyWhenNoQuadrupleMatches() {
        assertTrue(fourSum(new int[]{1, 2, 3, 4}, 100).isEmpty());
    }

    @Test
    void shouldNotOverflowOnLargeValues() {
        assertTrue(fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296).isEmpty());
    }

    @Test
    void shouldFindLargeValueQuadruple() {
        assertEquals(Set.of(List.of(-1000000000, -1000000000, 1000000000, 1000000000)),
                asSet(fourSum(new int[]{1000000000, 1000000000, -1000000000, -1000000000, 0}, 0)));
    }

    @Test
    void shouldDeduplicateAcrossRepeatedValues() {
        assertEquals(Set.of(List.of(-1, -1, 1, 1), List.of(-1, 0, 0, 1)),
                asSet(fourSum(new int[]{-1, -1, 0, 0, 0, 1, 1}, 0)));
    }

    @Test
    void shouldFindManyDistinctQuadruples() {
        assertEquals(Set.of(List.of(-3, -2, 2, 3), List.of(-3, -1, 1, 3), List.of(-3, 0, 0, 3),
                        List.of(-3, 0, 1, 2), List.of(-2, -1, 0, 3), List.of(-2, -1, 1, 2),
                        List.of(-2, 0, 0, 2), List.of(-1, 0, 0, 1)),
                asSet(fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0)));
    }

    @Test
    void shouldReturnSortedQuadruplesSummingToTarget() {
        for (List<Integer> quad : fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0)) {
            assertEquals(4, quad.size());
            assertTrue(quad.get(0) <= quad.get(1) && quad.get(1) <= quad.get(2) && quad.get(2) <= quad.get(3));
            assertEquals(0, quad.get(0) + quad.get(1) + quad.get(2) + quad.get(3));
        }
    }

    private static Set<List<Integer>> asSet(List<List<Integer>> res) {
        return new HashSet<>(res);
    }
}

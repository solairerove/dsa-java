package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0239_SlidingWindowMaximum.maxSlidingWindow;
import static com.solairerove.dsa.problems.P0239_SlidingWindowMaximum.maxSlidingWindowDeque;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0239_SlidingWindowMaximumTest {

    @Test
    void example() {
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    @Test
    void singleElement() {
        assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1}, 1));
    }

    @Test
    void windowOfOne() {
        assertArrayEquals(new int[]{4, 2, 7, 1}, maxSlidingWindow(new int[]{4, 2, 7, 1}, 1));
    }

    @Test
    void windowEqualsLength() {
        assertArrayEquals(new int[]{9}, maxSlidingWindow(new int[]{3, 9, 2, 5}, 4));
    }

    @Test
    void allEqual() {
        assertArrayEquals(new int[]{2, 2, 2}, maxSlidingWindow(new int[]{2, 2, 2, 2, 2}, 3));
    }

    @Test
    void strictlyIncreasing() {
        assertArrayEquals(new int[]{2, 3, 4, 5}, maxSlidingWindow(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    void strictlyDecreasing() {
        assertArrayEquals(new int[]{5, 4, 3, 2}, maxSlidingWindow(new int[]{5, 4, 3, 2, 1}, 2));
    }

    @Test
    void allNegative() {
        assertArrayEquals(new int[]{-2, -2, -3}, maxSlidingWindow(new int[]{-5, -2, -3, -4}, 2));
    }

    @Test
    void maxLeavesWindow() {
        assertArrayEquals(new int[]{9, 3, 3}, maxSlidingWindow(new int[]{9, 1, 3, 2}, 2));
    }

    @Test
    void duplicatesAtWindowEdge() {
        assertArrayEquals(new int[]{7, 7, 7, 7}, maxSlidingWindow(new int[]{7, 1, 7, 1, 7}, 2));
    }

    @Test
    void twoElements() {
        assertArrayEquals(new int[]{1}, maxSlidingWindow(new int[]{1, -1}, 2));
    }

    @Test
    void exampleDeque() {
        assertArrayEquals(new int[]{3, 3, 5, 5, 6, 7}, maxSlidingWindowDeque(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    @Test
    void singleElementDeque() {
        assertArrayEquals(new int[]{1}, maxSlidingWindowDeque(new int[]{1}, 1));
    }

    @Test
    void windowOfOneDeque() {
        assertArrayEquals(new int[]{4, 2, 7, 1}, maxSlidingWindowDeque(new int[]{4, 2, 7, 1}, 1));
    }

    @Test
    void windowEqualsLengthDeque() {
        assertArrayEquals(new int[]{9}, maxSlidingWindowDeque(new int[]{3, 9, 2, 5}, 4));
    }

    @Test
    void allEqualDeque() {
        assertArrayEquals(new int[]{2, 2, 2}, maxSlidingWindowDeque(new int[]{2, 2, 2, 2, 2}, 3));
    }

    @Test
    void strictlyIncreasingDeque() {
        assertArrayEquals(new int[]{2, 3, 4, 5}, maxSlidingWindowDeque(new int[]{1, 2, 3, 4, 5}, 2));
    }

    @Test
    void strictlyDecreasingDeque() {
        assertArrayEquals(new int[]{5, 4, 3, 2}, maxSlidingWindowDeque(new int[]{5, 4, 3, 2, 1}, 2));
    }

    @Test
    void allNegativeDeque() {
        assertArrayEquals(new int[]{-2, -2, -3}, maxSlidingWindowDeque(new int[]{-5, -2, -3, -4}, 2));
    }

    @Test
    void maxLeavesWindowDeque() {
        assertArrayEquals(new int[]{9, 3, 3}, maxSlidingWindowDeque(new int[]{9, 1, 3, 2}, 2));
    }

    @Test
    void duplicatesAtWindowEdgeDeque() {
        assertArrayEquals(new int[]{7, 7, 7, 7}, maxSlidingWindowDeque(new int[]{7, 1, 7, 1, 7}, 2));
    }

    @Test
    void twoElementsDeque() {
        assertArrayEquals(new int[]{1}, maxSlidingWindowDeque(new int[]{1, -1}, 2));
    }
}

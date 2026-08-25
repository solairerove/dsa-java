package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.solairerove.dsa.problems.P0011_ContainerWithMostWater.maxArea;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0011_ContainerWithMostWaterTest {

    @Test
    void shouldSolveExampleOne() {
        assertEquals(49, maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void shouldSolveExampleTwo() {
        assertEquals(1, maxArea(new int[]{1, 1}));
    }

    @Test
    void shouldHandleThreeBars() {
        assertEquals(2, maxArea(new int[]{1, 2, 1}));
    }

    @Test
    void shouldHandleTallestBarsAdjacent() {
        assertEquals(17, maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }

    @Test
    void shouldHandleStrictlyIncreasing() {
        assertEquals(6, maxArea(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void shouldHandleStrictlyDecreasing() {
        assertEquals(6, maxArea(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void shouldHandleAllEqualHeights() {
        assertEquals(9, maxArea(new int[]{3, 3, 3, 3}));
    }

    @Test
    void shouldHandleZeroHeights() {
        assertEquals(0, maxArea(new int[]{0, 0, 0}));
    }

    @Test
    void shouldHandleZeroPairedWithTallBar() {
        assertEquals(0, maxArea(new int[]{0, 2}));
    }

    @Test
    void shouldPreferWiderContainerOverTaller() {
        assertEquals(4, maxArea(new int[]{1, 2, 4, 3}));
    }

    @Test
    void shouldHandleTallBarsAtBothEnds() {
        assertEquals(9, maxArea(new int[]{9, 1, 1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    void shouldMatchBruteForceOnRandomInputs() {
        Random rnd = new Random(42);
        for (int t = 0; t < 200; t++) {
            int[] heights = new int[2 + rnd.nextInt(30)];
            for (int i = 0; i < heights.length; i++) {
                heights[i] = rnd.nextInt(20);
            }
            assertEquals(bruteForce(heights), maxArea(heights.clone()));
        }
    }

    private static int bruteForce(int[] heights) {
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                res = Math.max(res, Math.min(heights[i], heights[j]) * (j - i));
            }
        }

        return res;
    }
}

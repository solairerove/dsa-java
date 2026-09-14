package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.solairerove.dsa.problems.P0084_LargestRectangleInHistogram.largestRectangleArea;
import static com.solairerove.dsa.problems.P0084_LargestRectangleInHistogram.largestRectangleAreaArray;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0084_LargestRectangleInHistogramTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(10, largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(4, largestRectangleArea(new int[]{2, 4}));
    }

    @Test
    void emptyInput() {
        assertEquals(0, largestRectangleArea(new int[]{}));
    }

    @Test
    void singleBar() {
        assertEquals(7, largestRectangleArea(new int[]{7}));
    }

    @Test
    void singleZeroBar() {
        assertEquals(0, largestRectangleArea(new int[]{0}));
    }

    @Test
    void allZeroes() {
        assertEquals(0, largestRectangleArea(new int[]{0, 0, 0}));
    }

    @Test
    void allEqualBars() {
        assertEquals(12, largestRectangleArea(new int[]{3, 3, 3, 3}));
    }

    @Test
    void strictlyIncreasing() {
        assertEquals(9, largestRectangleArea(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void strictlyDecreasing() {
        assertEquals(9, largestRectangleArea(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void valleyShape() {
        assertEquals(5, largestRectangleArea(new int[]{4, 2, 1, 2, 4}));
    }

    @Test
    void zeroSplitsHistogram() {
        assertEquals(12, largestRectangleArea(new int[]{5, 5, 0, 4, 4, 4}));
    }

    @Test
    void tallSpikeBeatsWideBase() {
        assertEquals(100, largestRectangleArea(new int[]{2, 2, 2, 2, 2, 2, 100}));
    }

    @Test
    void duplicatesAdjacent() {
        assertEquals(6, largestRectangleArea(new int[]{2, 2, 2}));
    }

    @Test
    void plateauBetweenShortBars() {
        assertEquals(9, largestRectangleArea(new int[]{1, 3, 3, 3, 1}));
    }

    @Test
    void matchesBruteForceOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 300; t++) {
            int[] heights = new int[random.nextInt(12)];
            for (int i = 0; i < heights.length; i++) {
                heights[i] = random.nextInt(8);
            }
            assertEquals(bruteForce(heights), largestRectangleArea(heights));
        }
    }

    private static int bruteForce(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                max = Math.max(max, min * (j - i + 1));
            }
        }

        return max;
    }

    @Test
    void arrayLeetcodeExampleOne() {
        assertEquals(10, largestRectangleAreaArray(new int[]{2, 1, 5, 6, 2, 3}));
    }

    @Test
    void arrayLeetcodeExampleTwo() {
        assertEquals(4, largestRectangleAreaArray(new int[]{2, 4}));
    }

    @Test
    void arrayEmptyInput() {
        assertEquals(0, largestRectangleAreaArray(new int[]{}));
    }

    @Test
    void arraySingleBar() {
        assertEquals(7, largestRectangleAreaArray(new int[]{7}));
    }

    @Test
    void arraySingleZeroBar() {
        assertEquals(0, largestRectangleAreaArray(new int[]{0}));
    }

    @Test
    void arrayAllZeroes() {
        assertEquals(0, largestRectangleAreaArray(new int[]{0, 0, 0}));
    }

    @Test
    void arrayAllEqualBars() {
        assertEquals(12, largestRectangleAreaArray(new int[]{3, 3, 3, 3}));
    }

    @Test
    void arrayStrictlyIncreasing() {
        assertEquals(9, largestRectangleAreaArray(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void arrayStrictlyDecreasing() {
        assertEquals(9, largestRectangleAreaArray(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void arrayValleyShape() {
        assertEquals(5, largestRectangleAreaArray(new int[]{4, 2, 1, 2, 4}));
    }

    @Test
    void arrayZeroSplitsHistogram() {
        assertEquals(12, largestRectangleAreaArray(new int[]{5, 5, 0, 4, 4, 4}));
    }

    @Test
    void arrayTallSpikeBeatsWideBase() {
        assertEquals(100, largestRectangleAreaArray(new int[]{2, 2, 2, 2, 2, 2, 100}));
    }

    @Test
    void arrayDuplicatesAdjacent() {
        assertEquals(6, largestRectangleAreaArray(new int[]{2, 2, 2}));
    }

    @Test
    void arrayPlateauBetweenShortBars() {
        assertEquals(9, largestRectangleAreaArray(new int[]{1, 3, 3, 3, 1}));
    }

    @Test
    void arrayMatchesBruteForceOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 300; t++) {
            int[] heights = new int[random.nextInt(12)];
            for (int i = 0; i < heights.length; i++) {
                heights[i] = random.nextInt(8);
            }
            assertEquals(bruteForce(heights), largestRectangleAreaArray(heights));
        }
    }
}

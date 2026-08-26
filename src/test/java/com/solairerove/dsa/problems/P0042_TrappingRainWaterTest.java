package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.solairerove.dsa.problems.P0042_TrappingRainWater.trap;
import static com.solairerove.dsa.problems.P0042_TrappingRainWater.trapPrefixMax;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0042_TrappingRainWaterTest {

    @Test
    void shouldSolveExampleOne() {
        assertEquals(6, trapPrefixMax(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void shouldSolveExampleTwo() {
        assertEquals(9, trapPrefixMax(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    void shouldHandleSingleBar() {
        assertEquals(0, trapPrefixMax(new int[]{5}));
    }

    @Test
    void shouldHandleTwoBars() {
        assertEquals(0, trapPrefixMax(new int[]{5, 5}));
    }

    @Test
    void shouldHandleSimpleValley() {
        assertEquals(1, trapPrefixMax(new int[]{2, 1, 2}));
    }

    @Test
    void shouldHandleStrictlyIncreasing() {
        assertEquals(0, trapPrefixMax(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void shouldHandleStrictlyDecreasing() {
        assertEquals(0, trapPrefixMax(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void shouldHandleFlatSurface() {
        assertEquals(0, trapPrefixMax(new int[]{3, 3, 3, 3}));
    }

    @Test
    void shouldHandleAllZeros() {
        assertEquals(0, trapPrefixMax(new int[]{0, 0, 0}));
    }

    @Test
    void shouldHandleDeepBasin() {
        assertEquals(10, trapPrefixMax(new int[]{5, 0, 0, 5}));
    }

    @Test
    void shouldHandleTwoSeparateBasins() {
        assertEquals(4, trapPrefixMax(new int[]{3, 1, 3, 1, 3}));
    }

    @Test
    void shouldIgnoreWaterOutsideOuterWalls() {
        assertEquals(1, trapPrefixMax(new int[]{1, 4, 3, 4, 1}));
    }

    @Test
    void shouldMatchBruteForceOnRandomInputs() {
        Random rnd = new Random(42);
        for (int t = 0; t < 300; t++) {
            int[] height = new int[1 + rnd.nextInt(30)];
            for (int i = 0; i < height.length; i++) {
                height[i] = rnd.nextInt(10);
            }
            assertEquals(bruteForce(height), trapPrefixMax(height.clone()));
        }
    }

    @Test
    void shouldSolveExampleOneTwoPointer() {
        assertEquals(6, trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    @Test
    void shouldSolveExampleTwoTwoPointer() {
        assertEquals(9, trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    @Test
    void shouldHandleSingleBarTwoPointer() {
        assertEquals(0, trap(new int[]{5}));
    }

    @Test
    void shouldHandleTwoBarsTwoPointer() {
        assertEquals(0, trap(new int[]{5, 5}));
    }

    @Test
    void shouldHandleSimpleValleyTwoPointer() {
        assertEquals(1, trap(new int[]{2, 1, 2}));
    }

    @Test
    void shouldHandleStrictlyIncreasingTwoPointer() {
        assertEquals(0, trap(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void shouldHandleStrictlyDecreasingTwoPointer() {
        assertEquals(0, trap(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    void shouldHandleFlatSurfaceTwoPointer() {
        assertEquals(0, trap(new int[]{3, 3, 3, 3}));
    }

    @Test
    void shouldHandleAllZerosTwoPointer() {
        assertEquals(0, trap(new int[]{0, 0, 0}));
    }

    @Test
    void shouldHandleDeepBasinTwoPointer() {
        assertEquals(10, trap(new int[]{5, 0, 0, 5}));
    }

    @Test
    void shouldHandleTwoSeparateBasinsTwoPointer() {
        assertEquals(4, trap(new int[]{3, 1, 3, 1, 3}));
    }

    @Test
    void shouldIgnoreWaterOutsideOuterWallsTwoPointer() {
        assertEquals(1, trap(new int[]{1, 4, 3, 4, 1}));
    }

    @Test
    void shouldMatchBruteForceOnRandomInputsTwoPointer() {
        Random rnd = new Random(42);
        for (int t = 0; t < 300; t++) {
            int[] height = new int[1 + rnd.nextInt(30)];
            for (int i = 0; i < height.length; i++) {
                height[i] = rnd.nextInt(10);
            }
            assertEquals(bruteForce(height), trap(height.clone()));
        }
    }

    private static int bruteForce(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            int left = 0, right = 0;
            for (int j = 0; j <= i; j++) left = Math.max(left, height[j]);
            for (int j = i; j < height.length; j++) right = Math.max(right, height[j]);
            res += Math.min(left, right) - height[i];
        }

        return res;
    }
}

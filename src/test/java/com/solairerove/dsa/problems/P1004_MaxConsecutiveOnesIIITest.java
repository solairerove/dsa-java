package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P1004_MaxConsecutiveOnesIII.longestOnes;
import static com.solairerove.dsa.problems.P1004_MaxConsecutiveOnesIII.longestOnesCountingOnes;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P1004_MaxConsecutiveOnesIIITest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(6, longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(10, longestOnes(
                new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    @Test
    void allOnesNoFlipsNeeded() {
        assertEquals(5, longestOnes(new int[]{1, 1, 1, 1, 1}, 0));
    }

    @Test
    void allZerosFlipBudgetLimits() {
        assertEquals(2, longestOnes(new int[]{0, 0, 0, 0}, 2));
    }

    @Test
    void allZerosNoFlips() {
        assertEquals(0, longestOnes(new int[]{0, 0, 0}, 0));
    }

    @Test
    void flipBudgetExceedsZeroCount() {
        assertEquals(5, longestOnes(new int[]{1, 0, 1, 0, 1}, 10));
    }

    @Test
    void singleZeroNoFlips() {
        assertEquals(0, longestOnes(new int[]{0}, 0));
    }

    @Test
    void singleZeroOneFlip() {
        assertEquals(1, longestOnes(new int[]{0}, 1));
    }

    @Test
    void singleOne() {
        assertEquals(1, longestOnes(new int[]{1}, 0));
    }

    @Test
    void zerosOnlyAtEdges() {
        assertEquals(5, longestOnes(new int[]{0, 1, 1, 1, 0}, 2));
    }

    @Test
    void noFlipsPicksLongestExistingRun() {
        assertEquals(3, longestOnes(new int[]{1, 1, 0, 1, 1, 1, 0, 1}, 0));
    }

    @Test
    void bestWindowAtEnd() {
        assertEquals(4, longestOnes(new int[]{1, 0, 0, 1, 1, 0, 1}, 1));
    }

    @Test
    void alternatingPattern() {
        assertEquals(3, longestOnes(new int[]{1, 0, 1, 0, 1, 0}, 1));
    }

    @Test
    void bestWindowAtStart() {
        assertEquals(4, longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1}, 1));
    }

@Test
    void countingOnesLeetcodeExampleOne() {
        assertEquals(6, longestOnesCountingOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    void countingOnesLeetcodeExampleTwo() {
        assertEquals(10, longestOnesCountingOnes(
                new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }

    @Test
    void countingOnesAllOnesNoFlipsNeeded() {
        assertEquals(5, longestOnesCountingOnes(new int[]{1, 1, 1, 1, 1}, 0));
    }

    @Test
    void countingOnesAllZerosFlipBudgetLimits() {
        assertEquals(2, longestOnesCountingOnes(new int[]{0, 0, 0, 0}, 2));
    }

    @Test
    void countingOnesAllZerosNoFlips() {
        assertEquals(0, longestOnesCountingOnes(new int[]{0, 0, 0}, 0));
    }

    @Test
    void countingOnesFlipBudgetExceedsZeroCount() {
        assertEquals(5, longestOnesCountingOnes(new int[]{1, 0, 1, 0, 1}, 10));
    }

    @Test
    void countingOnesSingleZeroNoFlips() {
        assertEquals(0, longestOnesCountingOnes(new int[]{0}, 0));
    }

    @Test
    void countingOnesSingleZeroOneFlip() {
        assertEquals(1, longestOnesCountingOnes(new int[]{0}, 1));
    }

    @Test
    void countingOnesSingleOne() {
        assertEquals(1, longestOnesCountingOnes(new int[]{1}, 0));
    }

    @Test
    void countingOnesZerosOnlyAtEdges() {
        assertEquals(5, longestOnesCountingOnes(new int[]{0, 1, 1, 1, 0}, 2));
    }

    @Test
    void countingOnesNoFlipsPicksLongestExistingRun() {
        assertEquals(3, longestOnesCountingOnes(new int[]{1, 1, 0, 1, 1, 1, 0, 1}, 0));
    }

    @Test
    void countingOnesBestWindowAtEnd() {
        assertEquals(4, longestOnesCountingOnes(new int[]{1, 0, 0, 1, 1, 0, 1}, 1));
    }

    @Test
    void countingOnesAlternatingPattern() {
        assertEquals(3, longestOnesCountingOnes(new int[]{1, 0, 1, 0, 1, 0}, 1));
    }

    @Test
    void countingOnesBestWindowAtStart() {
        assertEquals(4, longestOnesCountingOnes(new int[]{1, 1, 1, 0, 0, 0, 1}, 1));
    }
}

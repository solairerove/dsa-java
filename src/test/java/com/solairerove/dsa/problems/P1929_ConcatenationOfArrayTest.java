package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P1929_ConcatenationOfArrayTest {

    @Test
    void concatenatesNaiveMultipleElements() {
        int[] nums = {1, 2, 1};

        int[] result = P1929_ConcatenationOfArray.getConcatenationNaive(nums);

        assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1}, result);
    }

    @Test
    void concatenatesNaiveSingleElement() {
        int[] nums = {1, 3, 2, 1};

        int[] result = P1929_ConcatenationOfArray.getConcatenationNaive(nums);

        assertArrayEquals(new int[]{1, 3, 2, 1, 1, 3, 2, 1}, result);
    }

    @Test
    void concatenatesDualWriteMultipleElements() {
        int[] nums = {1, 2, 1};

        int[] result = P1929_ConcatenationOfArray.getConcatenationDualWrite(nums);

        assertArrayEquals(new int[]{1, 2, 1, 1, 2, 1}, result);
    }

    @Test
    void concatenatesDualWriteSingleElement() {
        int[] nums = {1, 3, 2, 1};

        int[] result = P1929_ConcatenationOfArray.getConcatenationDualWrite(nums);

        assertArrayEquals(new int[]{1, 3, 2, 1, 1, 3, 2, 1}, result);
    }
}

package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0560_SubarraySumEqualsK.subarraySum;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0560_SubarraySumEqualsKTest {

    @Test
    void shouldCountTwoSubarraysInExampleOne() {
        assertEquals(2, subarraySum(new int[]{1, 1, 1}, 2));
    }

    @Test
    void shouldCountTwoSubarraysInExampleTwo() {
        assertEquals(2, subarraySum(new int[]{1, 2, 3}, 3));
    }

    @Test
    void shouldHandleSingleElementMatch() {
        assertEquals(1, subarraySum(new int[]{5}, 5));
    }

    @Test
    void shouldHandleSingleElementNoMatch() {
        assertEquals(0, subarraySum(new int[]{5}, 3));
    }

    @Test
    void shouldHandleNegativeNumbers() {
        assertEquals(3, subarraySum(new int[]{1, -1, 0}, 0));
    }

    @Test
    void shouldHandleAllZerosWithZeroTarget() {
        assertEquals(10, subarraySum(new int[]{0, 0, 0, 0}, 0));
    }

    @Test
    void shouldHandleNegativeTarget() {
        assertEquals(1, subarraySum(new int[]{-1, -1, 1}, -2));
    }

    @Test
    void shouldReturnZeroWhenNoSubarrayMatches() {
        assertEquals(0, subarraySum(new int[]{1, 2, 3}, 100));
    }

    @Test
    void shouldCountWholeArrayAsSingleMatch() {
        assertEquals(1, subarraySum(new int[]{2, 4, 6}, 12));
    }

    @Test
    void shouldCountOverlappingSubarrays() {
        assertEquals(4, subarraySum(new int[]{3, 4, 7, 2, -3, 1, 4, 2}, 7));
    }
}

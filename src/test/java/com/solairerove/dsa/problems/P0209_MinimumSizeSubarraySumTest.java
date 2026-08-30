package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0209_MinimumSizeSubarraySum.minSubArrayLen;
import static com.solairerove.dsa.problems.P0209_MinimumSizeSubarraySum.minSubArrayLenShrink;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0209_MinimumSizeSubarraySumTest {

    @Test
    void basicExample() {
        assertEquals(2, minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    void singleElementMeetsTarget() {
        assertEquals(1, minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    @Test
    void noSubarrayReachesTarget() {
        assertEquals(0, minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    void wholeArrayNeeded() {
        assertEquals(5, minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void emptyArray() {
        assertEquals(0, minSubArrayLen(1, new int[]{}));
    }

    @Test
    void singleElementTooSmall() {
        assertEquals(0, minSubArrayLen(5, new int[]{4}));
    }

    @Test
    void singleElementExact() {
        assertEquals(1, minSubArrayLen(5, new int[]{5}));
    }

    @Test
    void minimalWindowAtEnd() {
        assertEquals(1, minSubArrayLen(6, new int[]{1, 1, 1, 1, 7}));
    }

    @Test
    void minimalWindowAtStart() {
        assertEquals(1, minSubArrayLen(6, new int[]{7, 1, 1, 1, 1}));
    }

    @Test
    void allEqualElements() {
        assertEquals(3, minSubArrayLen(9, new int[]{3, 3, 3, 3}));
    }

    @Test
    void largeValuesNoOverflow() {
        assertEquals(2, minSubArrayLen(2000000000, new int[]{1000000000, 1000000000}));
    }

    @Test
    void targetExceedsTotalSum() {
        assertEquals(0, minSubArrayLen(100, new int[]{1, 2, 3}));
    }
    @Test
    void shrink_basicExample() {
        assertEquals(2, minSubArrayLenShrink(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    @Test
    void shrink_singleElementMeetsTarget() {
        assertEquals(1, minSubArrayLenShrink(4, new int[]{1, 4, 4}));
    }

    @Test
    void shrink_noSubarrayReachesTarget() {
        assertEquals(0, minSubArrayLenShrink(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    void shrink_wholeArrayNeeded() {
        assertEquals(5, minSubArrayLenShrink(15, new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void shrink_emptyArray() {
        assertEquals(0, minSubArrayLenShrink(1, new int[]{}));
    }

    @Test
    void shrink_singleElementTooSmall() {
        assertEquals(0, minSubArrayLenShrink(5, new int[]{4}));
    }

    @Test
    void shrink_singleElementExact() {
        assertEquals(1, minSubArrayLenShrink(5, new int[]{5}));
    }

    @Test
    void shrink_minimalWindowAtEnd() {
        assertEquals(1, minSubArrayLenShrink(6, new int[]{1, 1, 1, 1, 7}));
    }

    @Test
    void shrink_minimalWindowAtStart() {
        assertEquals(1, minSubArrayLenShrink(6, new int[]{7, 1, 1, 1, 1}));
    }

    @Test
    void shrink_allEqualElements() {
        assertEquals(3, minSubArrayLenShrink(9, new int[]{3, 3, 3, 3}));
    }

    @Test
    void shrink_largeValuesNoOverflow() {
        assertEquals(2, minSubArrayLenShrink(2000000000, new int[]{1000000000, 1000000000}));
    }

    @Test
    void shrink_targetExceedsTotalSum() {
        assertEquals(0, minSubArrayLenShrink(100, new int[]{1, 2, 3}));
    }
}

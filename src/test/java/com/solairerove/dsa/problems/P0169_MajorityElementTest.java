package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0169_MajorityElementTest {

    @Test
    void findsMajorityInSmallArray() {
        assertEquals(3, P0169_MajorityElement.majorityElement(new int[]{3, 2, 3}));
    }

    @Test
    void findsMajorityInUnsortedArray() {
        assertEquals(2, P0169_MajorityElement.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    @Test
    void handlesSingleElement() {
        assertEquals(1, P0169_MajorityElement.majorityElement(new int[]{1}));
    }

    @Test
    void handlesAllSameElements() {
        assertEquals(7, P0169_MajorityElement.majorityElement(new int[]{7, 7, 7, 7}));
    }

    @Test
    void handlesEvenLengthWithExactHalfPlusOne() {
        assertEquals(4, P0169_MajorityElement.majorityElement(new int[]{4, 1, 4, 4}));
    }

    @Test
    void handlesNegativeNumbers() {
        assertEquals(-5, P0169_MajorityElement.majorityElement(new int[]{-5, -5, 3, -5, 8}));
    }
}

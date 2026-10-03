package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0287_FindTheDuplicateNumber.findDuplicate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0287_FindTheDuplicateNumberTest {

    @Test
    void shouldFindDuplicateExampleOne() {
        assertEquals(2, findDuplicate(new int[]{1, 3, 4, 2, 2}));
    }

    @Test
    void shouldFindDuplicateExampleTwo() {
        assertEquals(3, findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }

    @Test
    void shouldFindDuplicateExampleThree() {
        assertEquals(3, findDuplicate(new int[]{3, 3, 3, 3, 3}));
    }

    @Test
    void shouldHandleMinimalInput() {
        assertEquals(1, findDuplicate(new int[]{1, 1}));
    }

    @Test
    void shouldFindDuplicateAtStart() {
        assertEquals(1, findDuplicate(new int[]{1, 1, 2}));
    }

    @Test
    void shouldFindDuplicateAtEnd() {
        assertEquals(4, findDuplicate(new int[]{1, 2, 3, 4, 4}));
    }

    @Test
    void shouldFindDuplicateRepeatedManyTimes() {
        assertEquals(2, findDuplicate(new int[]{2, 2, 2, 2, 2}));
    }

    @Test
    void shouldFindDuplicateWhenFirstElementIsNotDuplicate() {
        assertEquals(9, findDuplicate(new int[]{2, 5, 9, 6, 9, 3, 8, 9, 7, 1}));
    }

    @Test
    void shouldFindDuplicateInLargerArray() {
        int n = 10_000;
        int[] nums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        nums[n] = 5_000;
        assertEquals(5_000, findDuplicate(nums));
    }
}

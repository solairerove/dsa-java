package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.MountainArray;
import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P1095_FindInMountainArray.findInMountainArray;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P1095_FindInMountainArrayTest {

    @Test
    void shouldFindMinIndexExampleOne() {
        assertEquals(2, findInMountainArray(3, new MountainArray(new int[]{1, 2, 3, 4, 5, 3, 1})));
    }

    @Test
    void shouldReturnMinusOneExampleTwo() {
        assertEquals(-1, findInMountainArray(3, new MountainArray(new int[]{0, 1, 2, 4, 2, 1})));
    }

    @Test
    void shouldFindPeak() {
        assertEquals(3, findInMountainArray(4, new MountainArray(new int[]{0, 1, 2, 4, 2, 1})));
    }

    @Test
    void shouldFindOnlyOnRightSide() {
        assertEquals(5, findInMountainArray(0, new MountainArray(new int[]{1, 2, 5, 3, 1, 0})));
    }

    @Test
    void shouldFindFirstElement() {
        assertEquals(0, findInMountainArray(1, new MountainArray(new int[]{1, 5, 2})));
    }

    @Test
    void shouldFindLastElement() {
        assertEquals(2, findInMountainArray(2, new MountainArray(new int[]{1, 5, 2})));
    }

    @Test
    void shouldPreferLeftOccurrence() {
        assertEquals(1, findInMountainArray(2, new MountainArray(new int[]{1, 2, 3, 2, 1})));
    }

    @Test
    void shouldReturnMinusOneWhenAboveAll() {
        assertEquals(-1, findInMountainArray(10, new MountainArray(new int[]{1, 5, 2})));
    }

    @Test
    void shouldReturnMinusOneWhenBelowAll() {
        assertEquals(-1, findInMountainArray(0, new MountainArray(new int[]{1, 5, 2})));
    }

    @Test
    void shouldStayWithinCallLimitOnLargeInput() {
        int n = 10_000;
        int peak = 7_000;
        int[] arr = new int[n];
        for (int i = 0; i <= peak; i++) arr[i] = 2 * i;
        for (int i = peak + 1; i < n; i++) arr[i] = 2 * peak - 2 * (i - peak) + 1;
        MountainArray mountainArr = new MountainArray(arr);

        assertEquals(n - 1, findInMountainArray(arr[n - 1], mountainArr));
        assertTrue(mountainArr.calls() <= 100);
    }
}

package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.solairerove.dsa.problems.P0658_FindKClosestElements.findClosestElements;
import static com.solairerove.dsa.problems.P0658_FindKClosestElements.findClosestElementsBinarySearch;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0658_FindKClosestElementsTest {

    @Test
    void xInsideRange() {
        assertEquals(List.of(1, 2, 3, 4), findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }

    @Test
    void xBelowRange() {
        assertEquals(List.of(1, 2, 3, 4), findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }

    @Test
    void xAboveRange() {
        assertEquals(List.of(3, 4, 5), findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 10));
    }

    @Test
    void kEqualsLength() {
        assertEquals(List.of(1, 2, 3, 4, 5), findClosestElements(new int[]{1, 2, 3, 4, 5}, 5, 3));
    }

    @Test
    void kIsOne() {
        assertEquals(List.of(4), findClosestElements(new int[]{1, 2, 3, 4, 5}, 1, 4));
    }

    @Test
    void tiePrefersSmaller() {
        assertEquals(List.of(1, 2), findClosestElements(new int[]{1, 2, 3, 4}, 2, 2));
    }

    @Test
    void tieExactMidpoint() {
        assertEquals(List.of(2, 3), findClosestElements(new int[]{1, 2, 3, 4}, 2, 3));
    }

    @Test
    void duplicates() {
        assertEquals(List.of(2, 2, 2), findClosestElements(new int[]{1, 2, 2, 2, 3}, 3, 2));
    }

    @Test
    void negativeValues() {
        assertEquals(List.of(-3, -2, -1), findClosestElements(new int[]{-5, -3, -2, -1, 4}, 3, -2));
    }

    @Test
    void singleElementArray() {
        assertEquals(List.of(7), findClosestElements(new int[]{7}, 1, 100));
    }

    @Test
    void xEqualsFirstElement() {
        assertEquals(List.of(1, 2, 3), findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 1));
    }

    @Test
    void xEqualsLastElement() {
        assertEquals(List.of(3, 4, 5), findClosestElements(new int[]{1, 2, 3, 4, 5}, 3, 5));
    }

    @Test
    void sparseGaps() {
        assertEquals(List.of(10, 20), findClosestElements(new int[]{10, 20, 40, 80}, 2, 12));
    }
    @Test
    void binarySearch_xInsideRange() {
        assertEquals(List.of(1, 2, 3, 4), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }

    @Test
    void binarySearch_xBelowRange() {
        assertEquals(List.of(1, 2, 3, 4), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4, 5}, 4, -1));
    }

    @Test
    void binarySearch_xAboveRange() {
        assertEquals(List.of(3, 4, 5), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4, 5}, 3, 10));
    }

    @Test
    void binarySearch_kEqualsLength() {
        assertEquals(List.of(1, 2, 3, 4, 5), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4, 5}, 5, 3));
    }

    @Test
    void binarySearch_kIsOne() {
        assertEquals(List.of(4), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4, 5}, 1, 4));
    }

    @Test
    void binarySearch_tiePrefersSmaller() {
        assertEquals(List.of(1, 2), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4}, 2, 2));
    }

    @Test
    void binarySearch_tieExactMidpoint() {
        assertEquals(List.of(2, 3), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4}, 2, 3));
    }

    @Test
    void binarySearch_duplicates() {
        assertEquals(List.of(2, 2, 2), findClosestElementsBinarySearch(new int[]{1, 2, 2, 2, 3}, 3, 2));
    }

    @Test
    void binarySearch_negativeValues() {
        assertEquals(List.of(-3, -2, -1), findClosestElementsBinarySearch(new int[]{-5, -3, -2, -1, 4}, 3, -2));
    }

    @Test
    void binarySearch_singleElementArray() {
        assertEquals(List.of(7), findClosestElementsBinarySearch(new int[]{7}, 1, 100));
    }

    @Test
    void binarySearch_xEqualsFirstElement() {
        assertEquals(List.of(1, 2, 3), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4, 5}, 3, 1));
    }

    @Test
    void binarySearch_xEqualsLastElement() {
        assertEquals(List.of(3, 4, 5), findClosestElementsBinarySearch(new int[]{1, 2, 3, 4, 5}, 3, 5));
    }

    @Test
    void binarySearch_sparseGaps() {
        assertEquals(List.of(10, 20), findClosestElementsBinarySearch(new int[]{10, 20, 40, 80}, 2, 12));
    }
}

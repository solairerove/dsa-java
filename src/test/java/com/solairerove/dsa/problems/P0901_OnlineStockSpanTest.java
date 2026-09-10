package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0901_OnlineStockSpanTest {

    private static int[] spansOf(int... prices) {
        P0901_OnlineStockSpan spanner = new P0901_OnlineStockSpan();
        int[] spans = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            spans[i] = spanner.next(prices[i]);
        }

        return spans;
    }

    @Test
    void followsLeetCodeExample() {
        assertArrayEquals(
                new int[]{1, 1, 1, 2, 1, 4, 6},
                spansOf(100, 80, 60, 70, 60, 75, 85));
    }

    @Test
    void singlePrice() {
        assertArrayEquals(new int[]{1}, spansOf(7));
    }

    @Test
    void firstCallAlwaysReturnsOne() {
        P0901_OnlineStockSpan spanner = new P0901_OnlineStockSpan();
        assertEquals(1, spanner.next(42));
    }

    @Test
    void strictlyIncreasingPrices() {
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, spansOf(1, 2, 3, 4, 5));
    }

    @Test
    void strictlyDecreasingPrices() {
        assertArrayEquals(new int[]{1, 1, 1, 1, 1}, spansOf(5, 4, 3, 2, 1));
    }

    @Test
    void allEqualPrices() {
        assertArrayEquals(new int[]{1, 2, 3, 4}, spansOf(10, 10, 10, 10));
    }

    @Test
    void equalPriceCountsAsSpan() {
        assertArrayEquals(new int[]{1, 2}, spansOf(31, 31));
    }

    @Test
    void dipThenRecover() {
        assertArrayEquals(new int[]{1, 1, 3}, spansOf(50, 40, 60));
    }

    @Test
    void plateauThenSpike() {
        assertArrayEquals(new int[]{1, 2, 1, 4}, spansOf(30, 30, 20, 100));
    }

    @Test
    void alternatingPrices() {
        assertArrayEquals(new int[]{1, 1, 3, 1, 5}, spansOf(20, 10, 30, 15, 40));
    }

    @Test
    void minimumPriceBoundary() {
        assertArrayEquals(new int[]{1, 1, 3}, spansOf(2, 1, 2));
    }

    @Test
    void maximumPriceBoundary() {
        assertArrayEquals(new int[]{1, 2}, spansOf(100000, 100000));
    }

    @Test
    void separateInstancesKeepIndependentState() {
        P0901_OnlineStockSpan first = new P0901_OnlineStockSpan();
        P0901_OnlineStockSpan second = new P0901_OnlineStockSpan();

        assertEquals(1, first.next(10));
        assertEquals(2, first.next(20));
        assertEquals(1, second.next(20));
        assertEquals(1, second.next(5));
    }

    @Test
    void longRunCollapsesIntoSingleSpan() {
        assertArrayEquals(
                new int[]{1, 1, 1, 1, 5},
                spansOf(9, 8, 7, 6, 10));
    }
}

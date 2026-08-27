package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0121_BestTimeToBuyAndSellStockTest {

    @Test
    void returnsMaxProfitOnSampleInput() {
        int[] prices = {7, 1, 5, 3, 6, 4};

        assertEquals(5, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void returnsZeroWhenPricesOnlyDecrease() {
        int[] prices = {7, 6, 4, 3, 1};

        assertEquals(0, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void returnsZeroOnSinglePrice() {
        int[] prices = {5};

        assertEquals(0, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void returnsZeroOnEmptyInput() {
        int[] prices = {};

        assertEquals(0, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void returnsZeroWhenAllPricesEqual() {
        int[] prices = {3, 3, 3, 3};

        assertEquals(0, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void returnsFullRangeWhenPricesIncrease() {
        int[] prices = {1, 2, 3, 4, 5};

        assertEquals(4, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void picksLaterLowerValleyForBiggerProfit() {
        int[] prices = {3, 2, 6, 1, 9};

        assertEquals(8, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }

    @Test
    void returnsProfitOnTwoElements() {
        int[] prices = {2, 4};

        assertEquals(2, P0121_BestTimeToBuyAndSellStock.maxProfit(prices));
    }
}

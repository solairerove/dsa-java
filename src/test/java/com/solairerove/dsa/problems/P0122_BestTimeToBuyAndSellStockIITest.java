package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SuppressWarnings("NewClassNamingConvention")
class P0122_BestTimeToBuyAndSellStockIITest {

    @Test
    void maxProfit_example1() {
        assertEquals(7, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    void maxProfit_example2() {
        assertEquals(4, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void maxProfit_example3() {
        assertEquals(0, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    @Test
    void maxProfit_singlePrice() {
        assertEquals(0, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{5}));
    }

    @Test
    void maxProfit_twoPricesRising() {
        assertEquals(4, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 5}));
    }

    @Test
    void maxProfit_twoPricesFalling() {
        assertEquals(0, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{5, 1}));
    }

    @Test
    void maxProfit_allEqual() {
        assertEquals(0, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{3, 3, 3, 3}));
    }

    @Test
    void maxProfit_zigzag() {
        assertEquals(6, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 3, 1, 3, 1, 3}));
    }

    @Test
    void maxProfit_plateausDoNotAddProfit() {
        assertEquals(4, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 1, 2, 2, 5, 5}));
    }

    @Test
    void maxProfit_singlePeakThenDrop() {
        assertEquals(9, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{1, 10, 2}));
    }

    @Test
    void maxProfit_zeros() {
        assertEquals(0, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{0, 0, 0}));
    }

    @Test
    void maxProfit_boundaryValues() {
        assertEquals(20000, P0122_BestTimeToBuyAndSellStockII.maxProfit(new int[]{0, 10000, 0, 10000}));
    }

    @Test
    void maxProfit_doesNotMutateInput() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Integer i = P0122_BestTimeToBuyAndSellStockII.maxProfit(prices);

        assertNotNull(i);
        assertEquals(7, prices[0]);
        assertEquals(1, prices[1]);
        assertEquals(5, prices[2]);
        assertEquals(3, prices[3]);
        assertEquals(6, prices[4]);
        assertEquals(4, prices[5]);
    }

    @Test
    void maxProfit_matchesPeakValleyOnRandomInput() {
        Random random = new Random(122);
        for (int t = 0; t < 200; t++) {
            int[] prices = new int[1 + random.nextInt(60)];
            for (int i = 0; i < prices.length; i++) {
                prices[i] = random.nextInt(50);
            }

            int expected = 0;
            int i = 0;
            while (i < prices.length - 1) {
                while (i < prices.length - 1 && prices[i + 1] <= prices[i]) {
                    i++;
                }
                int valley = prices[i];
                while (i < prices.length - 1 && prices[i + 1] >= prices[i]) {
                    i++;
                }
                expected += prices[i] - valley;
            }

            assertEquals(expected, P0122_BestTimeToBuyAndSellStockII.maxProfit(prices));
        }
    }
}

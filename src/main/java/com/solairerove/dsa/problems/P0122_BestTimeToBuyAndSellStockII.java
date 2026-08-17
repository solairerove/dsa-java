package com.solairerove.dsa.problems;

public class P0122_BestTimeToBuyAndSellStockII {

    // time O(n), space O(1)
    public static int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                res += (prices[i] - prices[i - 1]);
            }
        }

        return res;
    }
}

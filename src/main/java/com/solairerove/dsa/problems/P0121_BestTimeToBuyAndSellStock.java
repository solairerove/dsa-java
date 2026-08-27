package com.solairerove.dsa.problems;

public class P0121_BestTimeToBuyAndSellStock {

    // time O(n), space O(1)
    public static int maxProfit(int[] prices) {
        int l = 0, r = 1;
        int res = 0;
        while (r < prices.length) {
            if (prices[l] < prices[r]) res = Math.max(res, prices[r] - prices[l]);
            else l = r;

            r++;
        }

        return res;
    }
}

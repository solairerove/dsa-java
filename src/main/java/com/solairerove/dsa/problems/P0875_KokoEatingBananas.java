package com.solairerove.dsa.problems;

public class P0875_KokoEatingBananas {

    // time O(n * log(max(piles))), space O(1)
    public static int minEatingSpeed(int[] piles, int h) {
        // minimum k is in range of [1..max(piles)]
        int n = piles.length;
        int maxPile = piles[0];
        for (int i = 1; i < n; i++) {
            if (piles[i] > maxPile) {
                maxPile = piles[i];
            }
        }

        int l = 1, r = maxPile;
        while (l < r) {
            int mid = l + (r - l) / 2;
            // linear search? check time to eat all piles with that eating rate

            int hours = 0;
            for (int pile : piles) {
                hours = (int) (hours + Math.ceil((double) pile / mid));
            }

            if (hours <= h) {
                r = mid;
            } else {
                l = mid + 1; // if hour > h it means that we need to increase eating rate
            }
        }

        return r;
    }
}

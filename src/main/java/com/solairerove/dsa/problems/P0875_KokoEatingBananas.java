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

    // time O(n + n * log(range)), space O(1)
    // same binary search, but over a narrowed range of speeds:
    // left is ceil(total / h), the rate needed with no rounding waste at all,
    // right is a rate already proven to finish in h hours
    public static int minEatingSpeedTightBounds(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        for (int p : piles) {
            total += p;
        }

        int left = (int) ((total - 1) / h) + 1; // minimum number of bananas she eats per hour.
        int right = (int) ((total - n) / (h - n + 1)) + 1; // assuming she eats all the bananas from the biggest pile in 1 hour and then waits takes her time with the rest.

        while (left < right) {
            int mid = left + (right - left) / 2;
            int time = 0;
            for (int p : piles) { // calculating the total time it takes to eat the rest of the bananas at the current rate without using pointers.
                time += (p - 1) / mid + 1;
            }

            if (time > h) { // if the time currently is greater than h we should increase the min time.
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left; // since we need the minimum integer where she can eat all the bananas within the time.
    }
}

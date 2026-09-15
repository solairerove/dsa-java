package com.solairerove.dsa.problems;

import com.solairerove.dsa.common.GuessGame;

public class P0374_GuessNumberHigherOrLower extends GuessGame {

    public P0374_GuessNumberHigherOrLower(int picked) {
        super(picked);
    }

    // time O(log n), space O(1)
    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int pick = (l + r) >>> 1;
            int res = guess(pick);
            if (res == 0) {
                return pick;
            } else if (res < 0) {
                r = pick - 1;
            } else {
                l = pick + 1;
            }
        }

        return n;
    }
}

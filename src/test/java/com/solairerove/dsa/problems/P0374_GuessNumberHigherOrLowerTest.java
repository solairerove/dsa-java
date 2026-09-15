package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0374_GuessNumberHigherOrLowerTest {

    private static int guessNumber(int n, int picked) {
        return new P0374_GuessNumberHigherOrLower(picked).guessNumber(n);
    }

    @Test
    void leetcodeExampleOne() {
        assertEquals(6, guessNumber(10, 6));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(1, guessNumber(1, 1));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(1, guessNumber(2, 1));
    }

    @Test
    void pickedIsUpperBound() {
        assertEquals(2, guessNumber(2, 2));
        assertEquals(10, guessNumber(10, 10));
    }

    @Test
    void pickedIsLowerBound() {
        assertEquals(1, guessNumber(10, 1));
    }

    @Test
    void maxIntNoOverflow() {
        assertEquals(Integer.MAX_VALUE, guessNumber(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE - 1, guessNumber(Integer.MAX_VALUE, Integer.MAX_VALUE - 1));
        assertEquals(1, guessNumber(Integer.MAX_VALUE, 1));
    }

    @Test
    void everyPickInSmallRange() {
        for (int n = 1; n <= 100; n++) {
            for (int picked = 1; picked <= n; picked++) {
                assertEquals(picked, guessNumber(n, picked));
            }
        }
    }

    @Test
    void usesLogarithmicNumberOfGuesses() {
        P0374_GuessNumberHigherOrLower game = new P0374_GuessNumberHigherOrLower(1_702_766_719);
        assertEquals(1_702_766_719, game.guessNumber(2_126_753_390));
        assertTrue(game.calls() <= 32, "calls: " + game.calls());
    }

    @Test
    void randomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 1_000; t++) {
            int n = random.nextInt(1, Integer.MAX_VALUE);
            int picked = random.nextInt(1, n + 1);

            P0374_GuessNumberHigherOrLower game = new P0374_GuessNumberHigherOrLower(picked);
            assertEquals(picked, game.guessNumber(n));
            assertTrue(game.calls() <= 32, "calls: " + game.calls());
        }
    }
}

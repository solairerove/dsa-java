package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.solairerove.dsa.problems.P0881_BoatsToSavePeople.numRescueBoats;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0881_BoatsToSavePeopleTest {

    @Test
    void shouldSolveExampleOne() {
        assertEquals(1, numRescueBoats(new int[]{1, 2}, 3));
    }

    @Test
    void shouldSolveExampleTwo() {
        assertEquals(3, numRescueBoats(new int[]{3, 2, 2, 1}, 3));
    }

    @Test
    void shouldSolveExampleThree() {
        assertEquals(4, numRescueBoats(new int[]{3, 5, 3, 4}, 5));
    }

    @Test
    void shouldHandleSinglePerson() {
        assertEquals(1, numRescueBoats(new int[]{5}, 5));
    }

    @Test
    void shouldHandleEveryoneAtLimit() {
        assertEquals(4, numRescueBoats(new int[]{4, 4, 4, 4}, 4));
    }

    @Test
    void shouldPairAllWhenLimitIsGenerous() {
        assertEquals(3, numRescueBoats(new int[]{1, 1, 1, 1, 1, 1}, 2));
    }

    @Test
    void shouldPairLightestWithHeaviest() {
        assertEquals(3, numRescueBoats(new int[]{1, 1, 1, 5, 5, 5}, 6));
    }

    @Test
    void shouldHandleUnsortedInput() {
        assertEquals(3, numRescueBoats(new int[]{5, 1, 5, 1, 5, 1}, 6));
    }

    @Test
    void shouldHandleOddCountWithLeftoverPerson() {
        assertEquals(3, numRescueBoats(new int[]{2, 2, 2, 2, 2}, 4));
    }

    @Test
    void shouldHandleAllEqualHalfOfLimit() {
        assertEquals(2, numRescueBoats(new int[]{3, 3, 3, 3}, 6));
    }

    @Test
    void shouldHandleLargeSpread() {
        assertEquals(4, numRescueBoats(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 9));
    }

    @Test
    void shouldMatchBruteForceOnRandomInputs() {
        Random rnd = new Random(42);
        for (int t = 0; t < 300; t++) {
            int limit = 1 + rnd.nextInt(10);
            int[] people = new int[1 + rnd.nextInt(8)];
            for (int i = 0; i < people.length; i++) {
                people[i] = 1 + rnd.nextInt(limit);
            }
            assertEquals(bruteForce(people.clone(), limit), numRescueBoats(people.clone(), limit));
        }
    }

    private static int bruteForce(int[] people, int limit) {
        Arrays.sort(people);
        return search(people, new boolean[people.length], limit);
    }

    private static int search(int[] people, boolean[] used, int limit) {
        int first = -1;
        for (int i = 0; i < people.length; i++) {
            if (!used[i]) {
                first = i;
                break;
            }
        }
        if (first == -1) return 0;

        used[first] = true;
        int best = 1 + search(people, used, limit);
        for (int j = first + 1; j < people.length; j++) {
            if (!used[j] && people[first] + people[j] <= limit) {
                used[j] = true;
                best = Math.min(best, 1 + search(people, used, limit));
                used[j] = false;
            }
        }
        used[first] = false;

        return best;
    }
}

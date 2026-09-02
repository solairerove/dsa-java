package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0682_BaseballGame.calPoints;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0682_BaseballGameTest {

    @Test
    void example1() {
        assertEquals(30, calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }

    @Test
    void example2() {
        assertEquals(27, calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }

    @Test
    void example3() {
        assertEquals(0, calPoints(new String[]{"1", "C"}));
    }

    @Test
    void singleScore() {
        assertEquals(7, calPoints(new String[]{"7"}));
    }

    @Test
    void negativeScores() {
        assertEquals(-9, calPoints(new String[]{"-3", "-6"}));
    }

    @Test
    void onlyDoubles() {
        assertEquals(21, calPoints(new String[]{"3", "D", "D"}));
    }

    @Test
    void onlySums() {
        assertEquals(11, calPoints(new String[]{"1", "2", "+", "+"}));
    }

    @Test
    void cancelAfterSum() {
        assertEquals(4, calPoints(new String[]{"2", "2", "+", "C"}));
    }

    @Test
    void mixedAllOps() {
        assertEquals(13, calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+", "C"}));
    }

    @Test
    void zeroScores() {
        assertEquals(0, calPoints(new String[]{"0", "0", "+", "D"}));
    }
}

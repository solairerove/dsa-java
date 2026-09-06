package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0739_DailyTemperatures.dailyTemperatures;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0739_DailyTemperaturesTest {

    @Test
    void leetcodeExampleOne() {
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
    }

    @Test
    void leetcodeExampleTwo() {
        assertArrayEquals(new int[]{1, 1, 1, 0}, dailyTemperatures(new int[]{30, 40, 50, 60}));
    }

    @Test
    void leetcodeExampleThree() {
        assertArrayEquals(new int[]{1, 1, 0}, dailyTemperatures(new int[]{30, 60, 90}));
    }

    @Test
    void singleDay() {
        assertArrayEquals(new int[]{0}, dailyTemperatures(new int[]{55}));
    }

    @Test
    void emptyInput() {
        assertArrayEquals(new int[]{}, dailyTemperatures(new int[]{}));
    }

    @Test
    void strictlyDecreasingNeverWarmer() {
        assertArrayEquals(new int[]{0, 0, 0, 0}, dailyTemperatures(new int[]{90, 80, 70, 60}));
    }

    @Test
    void allEqualTemperatures() {
        assertArrayEquals(new int[]{0, 0, 0}, dailyTemperatures(new int[]{50, 50, 50}));
    }

    @Test
    void equalThenWarmer() {
        assertArrayEquals(new int[]{2, 1, 0}, dailyTemperatures(new int[]{50, 50, 51}));
    }

    @Test
    void lastDayIsWarmest() {
        assertArrayEquals(new int[]{4, 3, 2, 1, 0}, dailyTemperatures(new int[]{70, 69, 68, 67, 100}));
    }

    @Test
    void valleyThenSpike() {
        assertArrayEquals(new int[]{5, 1, 2, 1, 1, 0}, dailyTemperatures(new int[]{80, 30, 40, 35, 50, 100}));
    }

    @Test
    void boundaryTemperatures() {
        assertArrayEquals(new int[]{1, 0}, dailyTemperatures(new int[]{30, 100}));
    }

    @Test
    void twoDaysColderNext() {
        assertArrayEquals(new int[]{0, 0}, dailyTemperatures(new int[]{100, 30}));
    }
}

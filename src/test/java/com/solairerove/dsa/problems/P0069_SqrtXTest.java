package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.solairerove.dsa.problems.P0069_SqrtX.mySqrt;
import static com.solairerove.dsa.problems.P0069_SqrtX.mySqrtNewton;
import static com.solairerove.dsa.problems.P0069_SqrtX.mySqrtUpperBound;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0069_SqrtXTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(2, mySqrt(4));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(2, mySqrt(8));
    }

    @Test
    void zero() {
        assertEquals(0, mySqrt(0));
    }

    @Test
    void one() {
        assertEquals(1, mySqrt(1));
    }

    @Test
    void smallNonSquares() {
        assertEquals(1, mySqrt(2));
        assertEquals(1, mySqrt(3));
        assertEquals(2, mySqrt(5));
        assertEquals(3, mySqrt(15));
    }

    @Test
    void perfectSquares() {
        assertEquals(3, mySqrt(9));
        assertEquals(10, mySqrt(100));
        assertEquals(1_000, mySqrt(1_000_000));
    }

    @Test
    void justBelowPerfectSquare() {
        assertEquals(9, mySqrt(99));
        assertEquals(999, mySqrt(999_999));
    }

    @Test
    void maxIntNoOverflow() {
        assertEquals(46_340, mySqrt(Integer.MAX_VALUE));
    }

    @Test
    void largestPerfectSquareInIntRange() {
        assertEquals(46_340, mySqrt(46_340 * 46_340));
        assertEquals(46_339, mySqrt(46_340 * 46_340 - 1));
    }

    @Test
    void everyValueUpTo100k() {
        for (int x = 0; x <= 100_000; x++) {
            assertEquals((int) Math.sqrt(x), mySqrt(x));
        }
    }

    @Test
    void matchesMathSqrtOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 10_000; t++) {
            int x = random.nextInt(0, Integer.MAX_VALUE);
            assertEquals((int) Math.sqrt(x), mySqrt(x));
        }
    }

    @Test
    void newtonLeetcodeExampleOne() {
        assertEquals(2, mySqrtNewton(4));
    }

    @Test
    void newtonLeetcodeExampleTwo() {
        assertEquals(2, mySqrtNewton(8));
    }

    @Test
    void newtonZero() {
        assertEquals(0, mySqrtNewton(0));
    }

    @Test
    void newtonOne() {
        assertEquals(1, mySqrtNewton(1));
    }

    @Test
    void newtonSmallNonSquares() {
        assertEquals(1, mySqrtNewton(2));
        assertEquals(1, mySqrtNewton(3));
        assertEquals(2, mySqrtNewton(5));
        assertEquals(3, mySqrtNewton(15));
    }

    @Test
    void newtonPerfectSquares() {
        assertEquals(3, mySqrtNewton(9));
        assertEquals(10, mySqrtNewton(100));
        assertEquals(1_000, mySqrtNewton(1_000_000));
    }

    @Test
    void newtonJustBelowPerfectSquare() {
        assertEquals(9, mySqrtNewton(99));
        assertEquals(999, mySqrtNewton(999_999));
    }

    @Test
    void newtonMaxIntNoOverflow() {
        assertEquals(46_340, mySqrtNewton(Integer.MAX_VALUE));
    }

    @Test
    void newtonLargestPerfectSquareInIntRange() {
        assertEquals(46_340, mySqrtNewton(46_340 * 46_340));
        assertEquals(46_339, mySqrtNewton(46_340 * 46_340 - 1));
    }

    @Test
    void newtonEveryValueUpTo100k() {
        for (int x = 0; x <= 100_000; x++) {
            assertEquals((int) Math.sqrt(x), mySqrtNewton(x));
        }
    }

    @Test
    void newtonMatchesMathSqrtOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 10_000; t++) {
            int x = random.nextInt(0, Integer.MAX_VALUE);
            assertEquals((int) Math.sqrt(x), mySqrtNewton(x));
        }
    }

    @Test
    void upperBoundLeetcodeExampleOne() {
        assertEquals(2, mySqrtUpperBound(4));
    }

    @Test
    void upperBoundLeetcodeExampleTwo() {
        assertEquals(2, mySqrtUpperBound(8));
    }

    @Test
    void upperBoundZero() {
        assertEquals(0, mySqrtUpperBound(0));
    }

    @Test
    void upperBoundOne() {
        assertEquals(1, mySqrtUpperBound(1));
    }

    @Test
    void upperBoundSmallNonSquares() {
        assertEquals(1, mySqrtUpperBound(2));
        assertEquals(1, mySqrtUpperBound(3));
        assertEquals(2, mySqrtUpperBound(5));
        assertEquals(3, mySqrtUpperBound(15));
    }

    @Test
    void upperBoundPerfectSquares() {
        assertEquals(3, mySqrtUpperBound(9));
        assertEquals(10, mySqrtUpperBound(100));
        assertEquals(1_000, mySqrtUpperBound(1_000_000));
    }

    @Test
    void upperBoundJustBelowPerfectSquare() {
        assertEquals(9, mySqrtUpperBound(99));
        assertEquals(999, mySqrtUpperBound(999_999));
    }

    @Test
    void upperBoundMaxIntNoOverflow() {
        assertEquals(46_340, mySqrtUpperBound(Integer.MAX_VALUE));
    }

    @Test
    void upperBoundLargestPerfectSquareInIntRange() {
        assertEquals(46_340, mySqrtUpperBound(46_340 * 46_340));
        assertEquals(46_339, mySqrtUpperBound(46_340 * 46_340 - 1));
    }

    @Test
    void upperBoundEveryValueUpTo100k() {
        for (int x = 0; x <= 100_000; x++) {
            assertEquals((int) Math.sqrt(x), mySqrtUpperBound(x));
        }
    }

    @Test
    void upperBoundMatchesMathSqrtOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 10_000; t++) {
            int x = random.nextInt(0, Integer.MAX_VALUE);
            assertEquals((int) Math.sqrt(x), mySqrtUpperBound(x));
        }
    }
}

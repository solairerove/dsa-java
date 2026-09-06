package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0735_AsteroidCollision.asteroidCollision;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0735_AsteroidCollisionTest {

    @Test
    void smallerAsteroidExplodes() {
        assertArrayEquals(new int[]{5, 10}, asteroidCollision(new int[]{5, 10, -5}));
    }

    @Test
    void equalAsteroidsBothExplode() {
        assertArrayEquals(new int[]{}, asteroidCollision(new int[]{8, -8}));
    }

    @Test
    void chainOfCollisions() {
        assertArrayEquals(new int[]{10}, asteroidCollision(new int[]{10, 2, -5}));
    }

    @Test
    void noCollisionsWhenMovingApart() {
        assertArrayEquals(new int[]{-2, -1, 1, 2}, asteroidCollision(new int[]{-2, -1, 1, 2}));
    }

    @Test
    void allMovingRight() {
        assertArrayEquals(new int[]{1, 2, 3}, asteroidCollision(new int[]{1, 2, 3}));
    }

    @Test
    void allMovingLeft() {
        assertArrayEquals(new int[]{-1, -2, -3}, asteroidCollision(new int[]{-1, -2, -3}));
    }

    @Test
    void singleAsteroid() {
        assertArrayEquals(new int[]{42}, asteroidCollision(new int[]{42}));
    }

    @Test
    void emptyInput() {
        assertArrayEquals(new int[]{}, asteroidCollision(new int[]{}));
    }

    @Test
    void bigLeftMoverWipesOutSeveral() {
        assertArrayEquals(new int[]{-20}, asteroidCollision(new int[]{1, 2, 3, -20}));
    }

    @Test
    void leftMoverStoppedAfterWipingSome() {
        assertArrayEquals(new int[]{10}, asteroidCollision(new int[]{10, 2, 3, -5}));
    }

    @Test
    void survivorsOnBothSides() {
        assertArrayEquals(new int[]{-2, -1, -2, -2}, asteroidCollision(new int[]{-2, -1, 1, -2, -2}));
    }

    @Test
    void mutualDestructionLeavesNeighbours() {
        assertArrayEquals(new int[]{-4, 4}, asteroidCollision(new int[]{-4, 5, -5, 4}));
    }
}

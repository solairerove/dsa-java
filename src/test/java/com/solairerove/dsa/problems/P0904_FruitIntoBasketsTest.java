package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static com.solairerove.dsa.problems.P0904_FruitIntoBaskets.totalFruit;
import static com.solairerove.dsa.problems.P0904_FruitIntoBaskets.totalFruitTwoPointer;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0904_FruitIntoBasketsTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(3, totalFruit(new int[]{1, 2, 1}));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(3, totalFruit(new int[]{0, 1, 2, 2}));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(4, totalFruit(new int[]{1, 2, 3, 2, 2}));
    }

    @Test
    void leetcodeExampleFour() {
        assertEquals(5, totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    @Test
    void emptyArray() {
        assertEquals(0, totalFruit(new int[]{}));
    }

    @Test
    void singleFruit() {
        assertEquals(1, totalFruit(new int[]{5}));
    }

    @Test
    void twoDistinctFruits() {
        assertEquals(2, totalFruit(new int[]{1, 2}));
    }

    @Test
    void twoSameFruits() {
        assertEquals(2, totalFruit(new int[]{1, 1}));
    }

    @Test
    void allSameFruit() {
        assertEquals(4, totalFruit(new int[]{7, 7, 7, 7}));
    }

    @Test
    void threeDistinctFruits() {
        assertEquals(2, totalFruit(new int[]{1, 2, 3}));
    }

    @Test
    void alternatingTwoTypes() {
        assertEquals(6, totalFruit(new int[]{1, 2, 1, 2, 1, 2}));
    }

    @Test
    void allDistinctFruits() {
        assertEquals(2, totalFruit(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void bestWindowAtStart() {
        assertEquals(4, totalFruit(new int[]{1, 2, 1, 2, 3}));
    }

    @Test
    void bestWindowAtEnd() {
        assertEquals(4, totalFruit(new int[]{3, 1, 2, 1, 2}));
    }

    @Test
    void bestWindowInMiddle() {
        assertEquals(5, totalFruit(new int[]{0, 1, 6, 6, 4, 4, 6}));
    }

    @Test
    void twoPointerLeetcodeExampleOne() {
        assertEquals(3, totalFruitTwoPointer(new int[]{1, 2, 1}));
    }

    @Test
    void twoPointerLeetcodeExampleTwo() {
        assertEquals(3, totalFruitTwoPointer(new int[]{0, 1, 2, 2}));
    }

    @Test
    void twoPointerLeetcodeExampleThree() {
        assertEquals(4, totalFruitTwoPointer(new int[]{1, 2, 3, 2, 2}));
    }

    @Test
    void twoPointerLeetcodeExampleFour() {
        assertEquals(5, totalFruitTwoPointer(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4}));
    }

    @Test
    void twoPointerEmptyArray() {
        assertEquals(0, totalFruitTwoPointer(new int[]{}));
    }

    @Test
    void twoPointerSingleFruit() {
        assertEquals(1, totalFruitTwoPointer(new int[]{5}));
    }

    @Test
    void twoPointerTwoDistinctFruits() {
        assertEquals(2, totalFruitTwoPointer(new int[]{1, 2}));
    }

    @Test
    void twoPointerTwoSameFruits() {
        assertEquals(2, totalFruitTwoPointer(new int[]{1, 1}));
    }

    @Test
    void twoPointerAllSameFruit() {
        assertEquals(4, totalFruitTwoPointer(new int[]{7, 7, 7, 7}));
    }

    @Test
    void twoPointerThreeDistinctFruits() {
        assertEquals(2, totalFruitTwoPointer(new int[]{1, 2, 3}));
    }

    @Test
    void twoPointerAlternatingTwoTypes() {
        assertEquals(6, totalFruitTwoPointer(new int[]{1, 2, 1, 2, 1, 2}));
    }

    @Test
    void twoPointerAllDistinctFruits() {
        assertEquals(2, totalFruitTwoPointer(new int[]{1, 2, 3, 4, 5}));
    }

    @Test
    void twoPointerBestWindowAtStart() {
        assertEquals(4, totalFruitTwoPointer(new int[]{1, 2, 1, 2, 3}));
    }

    @Test
    void twoPointerBestWindowAtEnd() {
        assertEquals(4, totalFruitTwoPointer(new int[]{3, 1, 2, 1, 2}));
    }

    @Test
    void twoPointerBestWindowInMiddle() {
        assertEquals(5, totalFruitTwoPointer(new int[]{0, 1, 6, 6, 4, 4, 6}));
    }
}

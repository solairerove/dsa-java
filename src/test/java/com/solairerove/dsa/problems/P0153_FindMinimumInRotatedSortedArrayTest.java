package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static com.solairerove.dsa.problems.P0153_FindMinimumInRotatedSortedArray.findMin;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0153_FindMinimumInRotatedSortedArrayTest {

    @Test
    void leetcodeExampleOne() {
        assertEquals(1, findMin(new int[]{3, 4, 5, 1, 2}));
    }

    @Test
    void leetcodeExampleTwo() {
        assertEquals(0, findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
    }

    @Test
    void leetcodeExampleThree() {
        assertEquals(11, findMin(new int[]{11, 13, 15, 17}));
    }

    @Test
    void singleElement() {
        assertEquals(5, findMin(new int[]{5}));
    }

    @Test
    void twoElementsRotated() {
        assertEquals(1, findMin(new int[]{2, 1}));
    }

    @Test
    void twoElementsNotRotated() {
        assertEquals(1, findMin(new int[]{1, 2}));
    }

    @Test
    void minAtLastIndex() {
        assertEquals(1, findMin(new int[]{2, 3, 4, 5, 1}));
    }

    @Test
    void minAtSecondIndex() {
        assertEquals(1, findMin(new int[]{5, 1, 2, 3, 4}));
    }

    @Test
    void negativeValues() {
        assertEquals(-10, findMin(new int[]{0, 3, -10, -5, -2}));
    }

    @Test
    void extremeValues() {
        assertEquals(Integer.MIN_VALUE, findMin(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}));
    }

    @Test
    void everyRotationOfSortedArray() {
        int[] sorted = {-3, 0, 2, 5, 7, 9, 12};
        int n = sorted.length;
        for (int k = 0; k < n; k++) {
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) {
                rotated[i] = sorted[(i + k) % n];
            }
            assertEquals(-3, findMin(rotated));
        }
    }

    @Test
    void matchesStreamMinOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 300; t++) {
            int n = 1 + random.nextInt(20);
            int[] sorted = random.ints(-1000, 1000).distinct().limit(n).sorted().toArray();
            int k = random.nextInt(n);
            int[] rotated = new int[n];
            for (int i = 0; i < n; i++) {
                rotated[i] = sorted[(i + k) % n];
            }
            assertEquals(Arrays.stream(rotated).min().getAsInt(), findMin(rotated));
        }
    }
}

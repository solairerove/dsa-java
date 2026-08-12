package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0304_RangeSumQuery2DImmutableTest {

    private static final int[][] EXAMPLE = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
    };

    @Test
    void sumRegion_example1() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(EXAMPLE);
        assertEquals(8, obj.sumRegion(2, 1, 4, 3));
        assertEquals(11, obj.sumRegion(1, 1, 2, 2));
        assertEquals(12, obj.sumRegion(1, 2, 2, 4));
    }

    @Test
    void sumRegion_singleCell() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(EXAMPLE);
        assertEquals(3, obj.sumRegion(0, 0, 0, 0));
        assertEquals(5, obj.sumRegion(4, 4, 4, 4));
        assertEquals(6, obj.sumRegion(1, 1, 1, 1));
    }

    @Test
    void sumRegion_wholeMatrix() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(EXAMPLE);
        assertEquals(58, obj.sumRegion(0, 0, 4, 4));
    }

    @Test
    void sumRegion_singleRow() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{{1, 2, 3, 4}});
        assertEquals(10, obj.sumRegion(0, 0, 0, 3));
        assertEquals(5, obj.sumRegion(0, 1, 0, 2));
    }

    @Test
    void sumRegion_singleColumn() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{{1}, {2}, {3}, {4}});
        assertEquals(10, obj.sumRegion(0, 0, 3, 0));
        assertEquals(5, obj.sumRegion(1, 0, 2, 0));
    }

    @Test
    void sumRegion_oneByOneMatrix() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{{-7}});
        assertEquals(-7, obj.sumRegion(0, 0, 0, 0));
    }

    @Test
    void sumRegion_negativeValues() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {-1, -2, -3},
                {-4, -5, -6},
                {-7, -8, -9}
        });
        assertEquals(-45, obj.sumRegion(0, 0, 2, 2));
        assertEquals(-28, obj.sumRegion(1, 1, 2, 2));
        assertEquals(-5, obj.sumRegion(1, 1, 1, 1));
    }

    @Test
    void sumRegion_mixedSigns() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {1, -1, 2},
                {-2, 3, -3},
                {4, -4, 5}
        });
        assertEquals(5, obj.sumRegion(0, 0, 2, 2));
        assertEquals(1, obj.sumRegion(0, 0, 1, 1));
        assertEquals(1, obj.sumRegion(1, 1, 2, 2));
    }

    @Test
    void sumRegion_zeros() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[3][3]);
        assertEquals(0, obj.sumRegion(0, 0, 2, 2));
        assertEquals(0, obj.sumRegion(1, 1, 1, 1));
    }

    @Test
    void sumRegion_repeatedQueriesAreStable() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(EXAMPLE);
        assertEquals(8, obj.sumRegion(2, 1, 4, 3));
        assertEquals(8, obj.sumRegion(2, 1, 4, 3));
        assertEquals(11, obj.sumRegion(1, 1, 2, 2));
    }

    @Test
    void sumRegion_boundaryValues() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {-100000, 100000},
                {100000, -100000}
        });
        assertEquals(0, obj.sumRegion(0, 0, 1, 1));
        assertEquals(0, obj.sumRegion(0, 0, 0, 1));
        assertEquals(100000, obj.sumRegion(0, 1, 0, 1));
    }

    @Test
    void sumRegion_matchesBruteForceOnRandomInput() {
        Random random = new Random(304);
        int rows = 60, cols = 40;
        int[][] matrix = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = random.nextInt(20001) - 10000;
            }
        }

        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(matrix);
        for (int q = 0; q < 300; q++) {
            int row1 = random.nextInt(rows);
            int row2 = row1 + random.nextInt(rows - row1);
            int col1 = random.nextInt(cols);
            int col2 = col1 + random.nextInt(cols - col1);

            int expected = 0;
            for (int r = row1; r <= row2; r++) {
                for (int c = col1; c <= col2; c++) {
                    expected += matrix[r][c];
                }
            }

            assertEquals(expected, obj.sumRegion(row1, col1, row2, col2));
        }
    }
}

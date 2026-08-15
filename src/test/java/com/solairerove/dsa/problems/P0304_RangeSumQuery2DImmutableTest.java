package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("NewClassNamingConvention")
class P0304_RangeSumQuery2DImmutableTest {

    @Test
    void sumRegion_example1() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
        assertEquals(8, obj.sumRegion(2, 1, 4, 3));
        assertEquals(11, obj.sumRegion(1, 1, 2, 2));
        assertEquals(12, obj.sumRegion(1, 2, 2, 4));
    }

    @Test
    void sumRegion_singleCellMatrix() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{{7}});
        assertEquals(7, obj.sumRegion(0, 0, 0, 0));
    }

    @Test
    void sumRegion_singleCellQueries() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        assertEquals(1, obj.sumRegion(0, 0, 0, 0));
        assertEquals(5, obj.sumRegion(1, 1, 1, 1));
        assertEquals(9, obj.sumRegion(2, 2, 2, 2));
    }

    @Test
    void sumRegion_wholeMatrix() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        assertEquals(45, obj.sumRegion(0, 0, 2, 2));
    }

    @Test
    void sumRegion_singleRowMatrix() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{{1, 2, 3, 4, 5}});
        assertEquals(15, obj.sumRegion(0, 0, 0, 4));
        assertEquals(9, obj.sumRegion(0, 1, 0, 3));
        assertEquals(3, obj.sumRegion(0, 2, 0, 2));
    }

    @Test
    void sumRegion_singleColumnMatrix() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{{1}, {2}, {3}, {4}});
        assertEquals(10, obj.sumRegion(0, 0, 3, 0));
        assertEquals(5, obj.sumRegion(1, 0, 2, 0));
    }

    @Test
    void sumRegion_fullRowAndFullColumn() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        });
        assertEquals(15, obj.sumRegion(1, 0, 1, 2));
        assertEquals(18, obj.sumRegion(0, 2, 2, 2));
    }

    @Test
    void sumRegion_allNegative() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {-1, -2},
                {-3, -4}
        });
        assertEquals(-10, obj.sumRegion(0, 0, 1, 1));
        assertEquals(-7, obj.sumRegion(1, 0, 1, 1));
        assertEquals(-6, obj.sumRegion(0, 1, 1, 1));
    }

    @Test
    void sumRegion_mixedSignsCancelToZero() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {5, -5},
                {-5, 5}
        });
        assertEquals(0, obj.sumRegion(0, 0, 1, 1));
        assertEquals(0, obj.sumRegion(0, 0, 0, 1));
    }

    @Test
    void sumRegion_zeros() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {0, 0, 0},
                {0, 0, 0}
        });
        assertEquals(0, obj.sumRegion(0, 0, 1, 2));
    }

    @Test
    void sumRegion_boundaryValues() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {-10000, 10000},
                {10000, -10000}
        });
        assertEquals(0, obj.sumRegion(0, 0, 1, 1));
        assertEquals(-10000, obj.sumRegion(0, 0, 0, 0));
        assertEquals(10000, obj.sumRegion(0, 1, 0, 1));
        assertEquals(0, obj.sumRegion(0, 0, 1, 0));
    }

    @Test
    void sumRegion_repeatedQueriesAreStable() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {2, 4},
                {6, 8}
        });
        assertEquals(20, obj.sumRegion(0, 0, 1, 1));
        assertEquals(20, obj.sumRegion(0, 0, 1, 1));
        assertEquals(12, obj.sumRegion(0, 1, 1, 1));
    }

    @Test
    void sumRegion_doesNotMutateInputMatrix() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(matrix);
        obj.sumRegion(0, 0, 1, 1);

        assertEquals(1, matrix[0][0]);
        assertEquals(2, matrix[0][1]);
        assertEquals(3, matrix[1][0]);
        assertEquals(4, matrix[1][1]);
    }

    @Test
    void sumRegion_nonSquareMatrix() {
        P0304_RangeSumQuery2DImmutable obj = new P0304_RangeSumQuery2DImmutable(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        });
        assertEquals(36, obj.sumRegion(0, 0, 1, 3));
        assertEquals(18, obj.sumRegion(0, 1, 1, 2));
        assertEquals(26, obj.sumRegion(1, 0, 1, 3));
    }

    @Test
    void sumRegion_matchesBruteForceOnRandomInput() {
        Random random = new Random(304);
        int rows = 40, cols = 30;
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

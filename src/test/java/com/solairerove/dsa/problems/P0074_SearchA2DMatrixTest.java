package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.solairerove.dsa.problems.P0074_SearchA2DMatrix.searchMatrix;
import static com.solairerove.dsa.problems.P0074_SearchA2DMatrix.searchMatrixFlat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0074_SearchA2DMatrixTest {

    @Test
    void leetcodeExampleOne() {
        assertTrue(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    @Test
    void leetcodeExampleTwo() {
        assertFalse(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }

    @Test
    void singleCellFound() {
        assertTrue(searchMatrix(new int[][]{{5}}, 5));
    }

    @Test
    void singleCellMissing() {
        assertFalse(searchMatrix(new int[][]{{5}}, 3));
        assertFalse(searchMatrix(new int[][]{{5}}, 8));
    }

    @Test
    void singleRow() {
        int[][] matrix = {{1, 3, 5, 7}};
        assertTrue(searchMatrix(matrix, 1));
        assertTrue(searchMatrix(matrix, 7));
        assertFalse(searchMatrix(matrix, 0));
        assertFalse(searchMatrix(matrix, 4));
        assertFalse(searchMatrix(matrix, 8));
    }

    @Test
    void singleColumn() {
        int[][] matrix = {{1}, {3}, {5}};
        assertTrue(searchMatrix(matrix, 1));
        assertTrue(searchMatrix(matrix, 3));
        assertTrue(searchMatrix(matrix, 5));
        assertFalse(searchMatrix(matrix, 0));
        assertFalse(searchMatrix(matrix, 4));
        assertFalse(searchMatrix(matrix, 6));
    }

    @Test
    void firstAndLastElement() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrix(matrix, 1));
        assertTrue(searchMatrix(matrix, 60));
    }

    @Test
    void targetOutsideRange() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertFalse(searchMatrix(matrix, 0));
        assertFalse(searchMatrix(matrix, 61));
    }

    @Test
    void rowFirstElements() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrix(matrix, 10));
        assertTrue(searchMatrix(matrix, 23));
    }

    @Test
    void rowLastElements() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrix(matrix, 7));
        assertTrue(searchMatrix(matrix, 20));
    }

    @Test
    void gapsBetweenRows() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertFalse(searchMatrix(matrix, 8));
        assertFalse(searchMatrix(matrix, 9));
        assertFalse(searchMatrix(matrix, 21));
        assertFalse(searchMatrix(matrix, 22));
    }

    @Test
    void negativeValues() {
        int[][] matrix = {{-10, -8}, {-5, -1}, {0, 4}};
        assertTrue(searchMatrix(matrix, -10));
        assertTrue(searchMatrix(matrix, -5));
        assertTrue(searchMatrix(matrix, 0));
        assertFalse(searchMatrix(matrix, -7));
        assertFalse(searchMatrix(matrix, 3));
    }

    @Test
    void extremeBoundsNoOverflow() {
        int[][] matrix = {{Integer.MIN_VALUE, -1}, {0, Integer.MAX_VALUE}};
        assertTrue(searchMatrix(matrix, Integer.MIN_VALUE));
        assertTrue(searchMatrix(matrix, Integer.MAX_VALUE));
        assertFalse(searchMatrix(matrix, 1));
    }

    @Test
    void everyValueInLargeMatrix() {
        int rows = 100, cols = 100;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (i * cols + j) * 2;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertTrue(searchMatrix(matrix, matrix[i][j]));
                assertFalse(searchMatrix(matrix, matrix[i][j] + 1));
            }
        }
    }

    @Test
    void matchesLinearScanOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 500; t++) {
            int rows = random.nextInt(1, 8);
            int cols = random.nextInt(1, 8);
            int[] flat = random.ints(rows * cols, -50, 50).distinct().sorted().toArray();
            if (flat.length < rows * cols) {
                continue;
            }

            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(flat, i * cols, matrix[i], 0, cols);
            }

            int target = random.nextInt(-55, 55);
            boolean expected = false;
            for (int value : flat) {
                if (value == target) {
                    expected = true;
                    break;
                }
            }

            assertEqualsBoolean(expected, searchMatrix(matrix, target));
        }
    }

    @Test
    void flatLeetcodeExampleOne() {
        assertTrue(searchMatrixFlat(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    @Test
    void flatLeetcodeExampleTwo() {
        assertFalse(searchMatrixFlat(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }

    @Test
    void flatSingleCellFound() {
        assertTrue(searchMatrixFlat(new int[][]{{5}}, 5));
    }

    @Test
    void flatSingleCellMissing() {
        assertFalse(searchMatrixFlat(new int[][]{{5}}, 3));
        assertFalse(searchMatrixFlat(new int[][]{{5}}, 8));
    }

    @Test
    void flatSingleRow() {
        int[][] matrix = {{1, 3, 5, 7}};
        assertTrue(searchMatrixFlat(matrix, 1));
        assertTrue(searchMatrixFlat(matrix, 7));
        assertFalse(searchMatrixFlat(matrix, 0));
        assertFalse(searchMatrixFlat(matrix, 4));
        assertFalse(searchMatrixFlat(matrix, 8));
    }

    @Test
    void flatSingleColumn() {
        int[][] matrix = {{1}, {3}, {5}};
        assertTrue(searchMatrixFlat(matrix, 1));
        assertTrue(searchMatrixFlat(matrix, 3));
        assertTrue(searchMatrixFlat(matrix, 5));
        assertFalse(searchMatrixFlat(matrix, 0));
        assertFalse(searchMatrixFlat(matrix, 4));
        assertFalse(searchMatrixFlat(matrix, 6));
    }

    @Test
    void flatFirstAndLastElement() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrixFlat(matrix, 1));
        assertTrue(searchMatrixFlat(matrix, 60));
    }

    @Test
    void flatTargetOutsideRange() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertFalse(searchMatrixFlat(matrix, 0));
        assertFalse(searchMatrixFlat(matrix, 61));
    }

    @Test
    void flatRowFirstElements() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrixFlat(matrix, 10));
        assertTrue(searchMatrixFlat(matrix, 23));
    }

    @Test
    void flatRowLastElements() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertTrue(searchMatrixFlat(matrix, 7));
        assertTrue(searchMatrixFlat(matrix, 20));
    }

    @Test
    void flatGapsBetweenRows() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        assertFalse(searchMatrixFlat(matrix, 8));
        assertFalse(searchMatrixFlat(matrix, 9));
        assertFalse(searchMatrixFlat(matrix, 21));
        assertFalse(searchMatrixFlat(matrix, 22));
    }

    @Test
    void flatNegativeValues() {
        int[][] matrix = {{-10, -8}, {-5, -1}, {0, 4}};
        assertTrue(searchMatrixFlat(matrix, -10));
        assertTrue(searchMatrixFlat(matrix, -5));
        assertTrue(searchMatrixFlat(matrix, 0));
        assertFalse(searchMatrixFlat(matrix, -7));
        assertFalse(searchMatrixFlat(matrix, 3));
    }

    @Test
    void flatExtremeBoundsNoOverflow() {
        int[][] matrix = {{Integer.MIN_VALUE, -1}, {0, Integer.MAX_VALUE}};
        assertTrue(searchMatrixFlat(matrix, Integer.MIN_VALUE));
        assertTrue(searchMatrixFlat(matrix, Integer.MAX_VALUE));
        assertFalse(searchMatrixFlat(matrix, 1));
    }

    @Test
    void flatEveryValueInLargeMatrix() {
        int rows = 100, cols = 100;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (i * cols + j) * 2;
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                assertTrue(searchMatrixFlat(matrix, matrix[i][j]));
                assertFalse(searchMatrixFlat(matrix, matrix[i][j] + 1));
            }
        }
    }

    @Test
    void flatMatchesLinearScanOnRandomInputs() {
        Random random = new Random(42);
        for (int t = 0; t < 500; t++) {
            int rows = random.nextInt(1, 8);
            int cols = random.nextInt(1, 8);
            int[] flat = random.ints(rows * cols, -50, 50).distinct().sorted().toArray();
            if (flat.length < rows * cols) {
                continue;
            }

            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                System.arraycopy(flat, i * cols, matrix[i], 0, cols);
            }

            int target = random.nextInt(-55, 55);
            boolean expected = false;
            for (int value : flat) {
                if (value == target) {
                    expected = true;
                    break;
                }
            }

            assertEqualsBoolean(expected, searchMatrixFlat(matrix, target));
        }
    }

    private static void assertEqualsBoolean(boolean expected, boolean actual) {
        if (expected) {
            assertTrue(actual);
        } else {
            assertFalse(actual);
        }
    }
}

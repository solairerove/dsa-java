package com.solairerove.dsa.problems;

public class P0304_RangeSumQuery2DImmutable {

    final int[][] ps;

    public P0304_RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length + 1, cols = matrix[0].length + 1;
        ps = new int[rows][cols];
        for (int r = 1; r < rows; r++) {
            for (int c = 1; c < cols; c++) {
                ps[r][c] = ps[r - 1][c] + ps[r][c - 1] - ps[r - 1][c - 1] + matrix[r - 1][c - 1];
            }
        }
    }

    // time O(1), space O(m * n)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;

        return ps[row2][col2] - ps[row1 - 1][col2] - ps[row2][col1 - 1] + ps[row1 - 1][col1 - 1];
    }
}

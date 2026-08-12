package com.solairerove.dsa.problems;

public class P0304_RangeSumQuery2DImmutable {

    final int[][] ps;

    public P0304_RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        ps = new int[rows + 1][cols + 1];
        for (int r = 0; r < rows; r++) {
            int prefix = 0;
            for (int c = 0; c < cols; c++) {
                prefix += matrix[r][c];
                int above = ps[r][c + 1];
                ps[r + 1][c + 1] = prefix + above;
            }
        }
    }

    // time O(1), space O(m * n)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        row1++;
        col1++;
        row2++;
        col2++;
        int bottomRight = ps[row2][col2];
        int above = ps[row1 - 1][col2];
        int left = ps[row2][col1 - 1];
        int topLeft = ps[row1 - 1][col1 - 1];

        return bottomRight - above - left + topLeft;
    }
}

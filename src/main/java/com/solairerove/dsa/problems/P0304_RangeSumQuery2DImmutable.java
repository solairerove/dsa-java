package com.solairerove.dsa.problems;

public class P0304_RangeSumQuery2DImmutable {

    int[][] ps;

    public P0304_RangeSumQuery2DImmutable(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        ps = new int[rows + 1][cols + 1];
        for (int r = 0; r < rows; r++) {
            int currentRowPrefix = 0;
            for (int c = 0; c < cols; c++) {
                currentRowPrefix += matrix[r][c];
                ps[r + 1][c + 1] = currentRowPrefix + ps[r][c + 1];
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
        int topRight = ps[row1 - 1][col2];
        int bottomLeft = ps[row2][col1 - 1];
        int topLeft = ps[row1 - 1][col1 - 1];

        return bottomRight - topRight - bottomLeft + topLeft;
    }
}

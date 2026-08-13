package com.solairerove.dsa.problems;

public class P0036_ValidSudoku {

    private final static int len = 9;

    // time O(1), space O(1)
    public static boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[len][len];
        boolean[][] cols = new boolean[len][len];
        boolean[][] squares = new boolean[len][len];

        for (int r = 0; r < len; r++) {
            for (int c = 0; c < len; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                int num = board[r][c] - '0' - 1;
                int box = r / 3 * 3 + c / 3;
                if (rows[r][num] || cols[c][num] || squares[box][num]) {
                    return false;
                }

                rows[r][num] = true;
                cols[c][num] = true;
                squares[box][num] = true;
            }
        }

        return true;
    }
}

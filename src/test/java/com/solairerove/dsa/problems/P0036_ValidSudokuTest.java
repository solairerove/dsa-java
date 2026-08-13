package com.solairerove.dsa.problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SuppressWarnings("NewClassNamingConvention")
class P0036_ValidSudokuTest {

    private static char[][] board(String... rows) {
        char[][] board = new char[9][];
        for (int r = 0; r < 9; r++) {
            board[r] = rows[r].toCharArray();
        }

        return board;
    }

    private static char[][] emptyBoard() {
        return board(
                ".........",
                ".........",
                ".........",
                ".........",
                ".........",
                ".........",
                ".........",
                ".........",
                ".........");
    }

    @Test
    void isValidSudoku_example1() {
        assertTrue(P0036_ValidSudoku.isValidSudoku(board(
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79")));
    }

    @Test
    void isValidSudoku_example2DuplicateInSquareAndColumn() {
        assertFalse(P0036_ValidSudoku.isValidSudoku(board(
                "83..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79")));
    }

    @Test
    void isValidSudoku_emptyBoardIsValid() {
        assertTrue(P0036_ValidSudoku.isValidSudoku(emptyBoard()));
    }

    @Test
    void isValidSudoku_duplicateInRow() {
        char[][] board = emptyBoard();
        board[0][0] = '5';
        board[0][8] = '5';

        assertFalse(P0036_ValidSudoku.isValidSudoku(board));
    }

    @Test
    void isValidSudoku_duplicateInColumn() {
        char[][] board = emptyBoard();
        board[0][3] = '9';
        board[8][3] = '9';

        assertFalse(P0036_ValidSudoku.isValidSudoku(board));
    }

    @Test
    void isValidSudoku_duplicateInSquareOnly() {
        char[][] board = emptyBoard();
        board[4][3] = '7';
        board[5][4] = '7';

        assertFalse(P0036_ValidSudoku.isValidSudoku(board));
    }

    @Test
    void isValidSudoku_sameDigitDifferentSquaresIsValid() {
        char[][] board = emptyBoard();
        board[0][0] = '1';
        board[3][3] = '1';
        board[6][6] = '1';

        assertTrue(P0036_ValidSudoku.isValidSudoku(board));
    }

    @Test
    void isValidSudoku_adjacentSquaresSameRowBandAreIndependent() {
        char[][] board = emptyBoard();
        board[0][0] = '4';
        board[1][3] = '4';
        board[2][6] = '4';

        assertTrue(P0036_ValidSudoku.isValidSudoku(board));
    }

    @Test
    void isValidSudoku_fullySolvedBoardIsValid() {
        assertTrue(P0036_ValidSudoku.isValidSudoku(board(
                "534678912",
                "672195348",
                "198342567",
                "859761423",
                "426853791",
                "713924856",
                "961537284",
                "287419635",
                "345286179")));
    }

    @Test
    void isValidSudoku_fullBoardWithSwapBreaksRow() {
        assertFalse(P0036_ValidSudoku.isValidSudoku(board(
                "534678912",
                "672195348",
                "198342567",
                "859761423",
                "426853791",
                "713924856",
                "961537284",
                "287419635",
                "345286177")));
    }

    @Test
    void isValidSudoku_lastCellDuplicateDetected() {
        char[][] board = emptyBoard();
        board[8][7] = '2';
        board[8][8] = '2';

        assertFalse(P0036_ValidSudoku.isValidSudoku(board));
    }

    @Test
    void isValidSudoku_doesNotMutateBoard() {
        char[][] board = board(
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79");
        char[][] copy = new char[9][];
        for (int r = 0; r < 9; r++) {
            copy[r] = board[r].clone();
        }

        P0036_ValidSudoku.isValidSudoku(board);

        for (int r = 0; r < 9; r++) {
            assertArrayEquals(copy[r], board[r]);
        }
    }
}

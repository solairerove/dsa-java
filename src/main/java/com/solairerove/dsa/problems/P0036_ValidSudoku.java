package com.solairerove.dsa.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P0036_ValidSudoku {

    // time O(1), space O(1)
    public static boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    continue;
                }

                String sqrKey = (r / 3) + "," + (c / 3);
                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                        cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                        squares.computeIfAbsent(sqrKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(sqrKey).add(board[r][c]);
            }
        }

        return true;
    }
}

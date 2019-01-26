package LeetCode;

import java.util.HashSet;

/**
 * Leetcode-36-Valid Sudoku-Medium
 *
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * A partially filled sudoku which is valid.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 *
 * Example 1:
 * Input:
 * [
 *   ["5","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: true
 *
 * Example 2:
 * Input:
 * [
 *   ["8","3",".",".","7",".",".",".","."],
 *   ["6",".",".","1","9","5",".",".","."],
 *   [".","9","8",".",".",".",".","6","."],
 *   ["8",".",".",".","6",".",".",".","3"],
 *   ["4",".",".","8",".","3",".",".","1"],
 *   ["7",".",".",".","2",".",".",".","6"],
 *   [".","6",".",".",".",".","2","8","."],
 *   [".",".",".","4","1","9",".",".","5"],
 *   [".",".",".",".","8",".",".","7","9"]
 * ]
 * Output: false
 *
 * Explanation: Same as Example 1, except with the 5 in the top left corner being
 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * The given board contain only digits 1-9 and the character '.'.
 * The given board size is always 9x9.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {

                // 判断行
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    // 如果rows已经存在这个数，再加会返回false
                    // 说明一行中有重复的数，直接返回false
                    return false;
                }

                // 判断列
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }


                // 0 1 2 3 4 5 6 7 8  棋盘index
                // 0 0 0 3 3 3 6 6 6  rowIndex
                // 0 3 6 0 3 6 0 3 6  colIndex

                // 0 0 0 3 3 3 6 6 6  j / 3
                // 0 1 2 0 1 2 0 1 2  j % 3


                // 用于确定哪个cube
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);

                // 每个cube里面的数是否符合要求
                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {

                if (board[i][j] == '.') {
                    continue;
                }
                if (!isValid(board, i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int row = 0; row < board.length; row++) {
            if (row == i) {
                continue;
            }

            // 在第j列，如果有两个数相同，则return false
            if (board[row][j] == board[i][j]) {
                return false;
            }
        }

        for (int col = 0; col < board[0].length; col++) {
            if (col == j) {
                continue;
            }

            // 在第i行，如果有两个数相同，则return false
            if (board[i][col] == board[i][j]) {
                return false;
            }
        }

        for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
                if (row == i && col == j) {
                    continue;
                }

                if (board[row][col] == board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
package LeetCode;

/**
 * Leetcode-79-Word Search-Medium
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) { // index表示当前判断的是word中的哪个字符
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int i, int j, String word, int index) {
        // index判断到word最后，return true
        if (index >= word.length()) {
            return true;
        }

        // 超过边界条件，return false
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }

        // 如果当前board的字符与word的相同，
        if (board[i][j] == word.charAt(index++)) {

            // 记录使用过的字符
            char c = board[i][j];

            // 使用过一次之后不能再次使用，故将其值赋为'#'
            board[i][j] = '#';

            // 组合情况有上下左右四种
            boolean result = exist(board, i + 1, j, word, index) ||
                    exist(board, i - 1, j, word, index) ||
                    exist(board, i, j + 1, word, index) ||
                    exist(board, i, j - 1, word, index);

            // 判断完之后，将原位置上的字符还原
            board[i][j] = c;
            return result;
        }

        return false;
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-51- N-Queens - Hard
 *
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 *
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 *
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 *
 * Example:
 *
 * Input: 4
 * Output: [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
 *
 *
 *
 *
 * [".Q..",
 *  "...Q",
 *  "Q...",
 *  "..Q."],
 * n = 4
 * queens[]: [1, 3, 0, 2]
 * queens[]: 表示从第0行到n-1行，每一行queen放置在哪一列
 * pos: 表示是哪一行
 *
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if (n <= 0) {
            return result;
        }
        help(result, new int[n], 0);

        return result;
    }

    private void help(List<List<String>> result, int[] queens, int pos) {

        // 遍历到最后一行
        if (pos == queens.length) {
            addSolution(result, queens);
            return;
        }
        for (int i = 0; i < queens.length; i++) {

            // 在第pos行，第i列放置queen
            queens[pos] = i;

            // 判断该处是否可行
            if (isValid(queens, pos)) {

                // BFS
                help(result, queens, pos + 1);
            }
        }
    }

    private boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; i++) {

            // 如果有不同的两行放置在同一列上，则不满足条件
            if (queens[i] == queens[pos]) {
                return false;
            } else if (Math.abs(queens[i] - queens[pos]) == Math.abs(i - pos)) {
                // 位于同一对角线也是不行的
                return false;
            }
        }

        return true;
    }

    private void addSolution(List<List<String>> result, int[] queens) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) {

                // 第i行queen放置在j这个位置
                if (queens[i] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }

        result.add(list);

    }
}

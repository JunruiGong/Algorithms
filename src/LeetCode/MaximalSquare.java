package LeetCode;

/**
 * Leetcode-221-Maximal Square-Medium
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        int[][] dp = new int[m + 1][n + 1];

        // dp[i][j]表示到达(i, j)位置所能组成的最大正方形的边长
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // 要想在dp[i][j]组成正方形，则matrix[i-1][j-1]必须等于1
                if (matrix[i - 1][j - 1] == '1') {

                    // 比较左上边，左边，上边，三个方位的值
                    // 最后加1是因为在dp[i][j]正方形的边长要比其左上边，左边和上边的正方形边长大1
                    // 取这三个数的最小值的原因是因为要取交集
                    // 假设dp[i - 1][j] = 1, dp[i][j - 1]) = 1, dp[i - 1][j - 1] = 2
                    // 取最大值的话，将左上角的正方形边长加1，可能并不能组成正方形
                    // 因为其他的位置可能值是0，但条件是不能有0的存在
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result * result;
    }
}

package LeetCode;

/**
 * Leetcode-62-Unique Paths-Medium
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 */
public class UniquePaths {

    // time: O(n*m)
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        // 每个格子存放的是到达该格子可以走的路径数量

        // 初始化第一行
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }

        // 初始化第一列
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // 根据题目要求，到达(i, j)这个位置只能从(i-1, j)或(i, j-1)出发
                // 所以到达(i, j)可以走的路径就是到达(i-1, j)和(i, j-1)的路径之和
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }

        // 返回最后一个格子的路径数量
        return result[m - 1][n - 1];
    }

    public int uniquePaths2(int m, int n) {
        int[]result = new int[n];

        result[0]=1;

        // 按层来计算
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[j] = result[j] + result[j - 1];
            }
        }

        // 返回最后一个格子的路径数量
        return result[n - 1];
    }
}

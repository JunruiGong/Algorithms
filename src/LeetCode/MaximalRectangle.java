package LeetCode;

import java.util.Arrays;

/**
 * Leetcode-85-Maximal Rectangle-Hard
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 *
 *
 *      1 0 1 0 0
 *      1 0 1 1 1
 *      1 1 1 1 1
 *      1 0 0 1 0
 *
 *
 *      left[]: 从左到右，出现连续'1'的string的第一个坐标
 *      right[]: 从右到左，出现连续'1'的string的最后一个坐标
 *      height[]: 从上到下的高度
 *      result = (right[j] - left[j]) * height[j]
 *
 *      height:
 *      1 0 1 0 0
 *      2 0 2 1 1
 *      3 1 3 2 2
 *      4 0 0 3 0
 *
 *      left:
 *      0 0 2 0 0
 *      0 0 2 2 2
 *      0 0 2 2 2  // 这里是2的原因是：left[j] = Math.max(left[j], curLeft);
 *      0 0 0 3 0
 *
 *      right:
 *      1 5 3 5 5
 *      1 5 3 5 5
 *      1 5 3 5 5
 *      1 5 5 4 5
 *
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m < 1 || n < 1) {
            return 0;
        }

        int result = 0;

        int[] height = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        for (int i = 0; i < m; i++) {
            int curLeft = 0;  // 表示当前left从哪个点开始
            int curRight = n;   // 表示当前right从哪个点开始
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], curLeft);
                } else {
                    // matrix[i][j] == '0'
                    // left移动到下一个点
                    left[j] = 0;
                    curLeft = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(curRight, right[j]);
                } else {
                    right[j] = n;
                    curRight = j;
                }
            }

            for (int j = 0; j < n; j++) {
                result = Math.max(result, (left[j] - right[j]) * height[j]);
            }
        }

        return result;

    }
}

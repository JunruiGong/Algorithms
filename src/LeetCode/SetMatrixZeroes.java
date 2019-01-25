package LeetCode;

/**
 * Leetcode-73-Set Matrix Zeroes-Medium
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 *
 * Example 1:
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * Example 2:
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * Follow up:
 *
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 */
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {

        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return;
        }

        int m = matrix.length;
        int n = matrix[0].length;


        boolean row = false;
        boolean col = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {

                    // 将该点所在的第一列设为0
                    matrix[i][0] = 0;

                    // 将该点所在的第一行设为0
                    matrix[0][j] = 0;
                    if (i == 0) {
                        row = true;
                    }

                    if (j == 0) {
                        col = true;
                    }
                }
            }
        }

        for (int i = 1; i < m; i++) {
            // 如果某一行的起始位置为0，则将该行全部置为0
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j++) {

            // 如果在第一行的某个位置为0，则将该位置所在列全部置为0
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        // 如果原数组第一行本身有0
        // 则将第一行全部置为0
        if (row) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;

            }
        }

        // 如果原数组第一列本身有0
        // 则将第一列全部置为0
        if (col) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

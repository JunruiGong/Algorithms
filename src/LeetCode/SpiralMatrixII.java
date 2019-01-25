package LeetCode;

import org.junit.Test;

/**
 * Leetcode-59-Spiral Matrix II-Medium
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;

        int num = 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {

            for (int i = colBegin; i <= colEnd; i++) {
                result[rowBegin][i] = num++;
                System.out.println(result[rowBegin][i]);
            }

            rowBegin++;

            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = num++;
                System.out.println(result[i][colEnd]);
            }

            colEnd--;

            if (rowBegin <= rowEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result[rowEnd][i] = num++;
                    System.out.println(result[rowEnd][i]);
                }
            }

            rowEnd--;

            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result[i][colBegin] = num++;
                    System.out.println(result[i][colBegin]);
                }
            }

            colBegin++;
        }

        return result;
    }

    @Test
    public void test() {
        System.out.println(generateMatrix(3));
    }
}

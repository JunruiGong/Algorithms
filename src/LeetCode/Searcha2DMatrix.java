package LeetCode;

import org.junit.Test;

/**
 * Leetcode-74-Search a 2D Matrix-Medium
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Example 2:
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1 || matrix[0] == null || matrix[0].length < 1) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        // 从右上角开始查找
        while (row < matrix.length && col >= 0) {

            // 找到了，返回true
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                // 大于target，向左移动，减少列坐标
                col--;
            } else {
                // 小于target，向下移动，增加行坐标
                row++;
            }
        }

        return false;

    }

    @Test
    public void test() {
        int[][] matrix = {{1}};
        int target = 0;

        System.out.println(searchMatrix(matrix, target));

    }
}

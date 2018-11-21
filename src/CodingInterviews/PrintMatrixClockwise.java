package CodingInterviews;
/**
 * CodingInterviews-20-顺时针打印矩阵
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * */

import org.junit.Test;

import java.util.ArrayList;

public class PrintMatrixClockwise {

    private ArrayList<Integer> printMatrix(int[][] matrix) {

        if (matrix == null) {
            return null;
        }

        int startX = 0;
        int startY = 0;
        int endX = matrix.length - 1;
        int endY = matrix[0].length - 1;

        ArrayList<Integer> result = new ArrayList<Integer>();
        while (startX <= endX && startY <= endY) {
            result = circleMatrix(matrix, startX, startY, endX, endY, result);
            startX++;
            startY++;
            endX--;
            endY--;
        }
        return result;
    }

    private ArrayList<Integer> circleMatrix(int[][] matrix, int startX, int startY, int endX, int endY, ArrayList<Integer> list) {
        if (startX == endX) {
            for (int i = startY; i <= endY; i++) {
                System.out.println(matrix[startX][i]);
                list.add(matrix[startX][i]);
            }
            return list;
        } else if (startY == endY) {
            for (int i = startX; i <= endX; i++) {
                list.add(matrix[i][endY]);
            }
            return list;
        } else {
            for (int i = startY; i < endY; i++) {
                System.out.println(matrix[startX][i]);
                list.add(matrix[startX][i]);
            }

            for (int i = startX; i < endX; i++) {
                System.out.println(matrix[i][endY]);
                list.add(matrix[i][startY]);
            }

            for (int i = endY; i > startY; i--) {
                System.out.println(matrix[endX][i]);
                list.add(matrix[endX][i]);
            }

            for (int i = endX; i > startX; i--) {
                System.out.println(matrix[i][startY]);
                list.add(matrix[i][startY]);
            }
        }
        return list;
    }

    @Test
    public void test() {

//        int[][] matrix = null;
//        int[][] matrix = {{1}};
//        int[][] matrix = {{1}, {2}, {3}, {4}};
        int[][] matrix = {{1, 2, 3, 4, 5}};
//        int[][] matrix = {{1, 2}, {3, 4}};
        ArrayList<Integer> arrayList = printMatrix(matrix);


        int i = 0;
        for (int j = 0; j < arrayList.size(); j++) {
            System.out.println(arrayList.get(i));
            i++;
        }
    }


}

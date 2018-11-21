package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-29-数组中出现次数超过一半的数字
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 */
public class MoreThanHalfNum {

    public int MoreThanHalfNum_Solution(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int count = 1;
        int result = array[0];


        for (int i = 1; i < array.length; i++) {
            if (result == array[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result = array[i];
                    count = 1;
                }
            }
        }

        if (checkMoreThanHalf(array, result)) {
            return result;
        } else {
            return 0;
        }
    }

    private boolean checkMoreThanHalf(int[] array, int result) {
        int count = 0;
        for (int anArray : array) {
            if (result == anArray) {
                count++;
            }
        }

        return count > array.length / 2;
    }


    //采用快速排的方式
    public int MoreThanHalfNum_Solution2(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        quickSort(array,0,array.length-1);

        int result = array[array.length/2];

        if(checkMoreThanHalf(array, result)){
            return result;

        }else{
            return 0;
        }

    }


    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {

        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void Test() {

        int[] array = {1, 2, 3, 2, 2, 2, 5, 4, 2};

        MoreThanHalfNum_Solution(array);
    }
}

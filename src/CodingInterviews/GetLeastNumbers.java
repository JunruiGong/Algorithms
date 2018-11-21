package CodingInterviews;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 剑指offer-30-最小的K个数
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */

public class GetLeastNumbers {


    //采用最小堆的方式
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        if (input.length == 0 || k < 1 || input.length < k) {
            return arrayList;
        }

        TreeSet<Integer> set = new TreeSet<Integer>();

        for (int i = 0; i < input.length; i++) {
            if (set.size() < k) {
                set.add(input[i]);
            } else {
                if (set.last() > input[i]) {
                    set.remove(set.last());
                    set.add(input[i]);
                }
            }
        }

        arrayList.addAll(set);

        return arrayList;
    }

    //Partition二分法
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        if (input.length == 0 || k < 1 || input.length < k) {
            return arrayList;
        }

        quickSort(input, 0, input.length - 1);


        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }

        return arrayList;


    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    //将数组进行划分，返回划分好之后pivot的位置。
    private int partition(int[] array, int low, int high) {

        //i相当于是分界点，在i左边的是小于pivot，在右边的是大于pivot的数。
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        //大小划分好之后将pivot放到分界点
        swap(array, i + 1, high);

        //返回划分之后pivot的位置。
        return i + 1;
    }

    @Test
    public void Test() {

        int[] array = {4, 7, 5, 9, 10, 6};

        GetLeastNumbers_Solution2(array, 4);
        for (int i : array) {
            System.out.println(array[i]);
        }
    }

}

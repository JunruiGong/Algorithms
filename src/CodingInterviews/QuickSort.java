package CodingInterviews;

import org.junit.Test;

public class QuickSort {

    private void quickSort(int[] array, int low, int high) {
        if (low < high) {

            int pivot = partition(array, low, high);

            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }


    private int partition(int[] arr, int low, int high) {

        // i相当于是分界点，在i左边的是小于pivot，在右边的是大于pivot的数。
        int pivot = arr[high];
        int i = (low - 1); // index of smaller element
        for (int j = low; j < high; j++) {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot) {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }


    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Test
    public void Test() {
        int[] array = {4, 7, 5, 9, 10, 6};
        quickSort(array, 0, array.length - 1);

        for(int a:array){
            System.out.println(a);
        }
    }
}

package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-38-数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 */
public class GetNumberOfK {

    public int getNumberOfK(int[] array, int k) {

        // 因为数组已经排好序，通过二分查找，查找k这个数第一次出现的index和最后一次出现的index
        // 就可以得到k这个数出现的次数。

        int number = 0;
        int firstIndex = -1;
        int lastIndex = -1;

        if (array.length > 0) {
            firstIndex = getFirstK(array, k, 0, array.length - 1);
            lastIndex = getLastK(array, k, 0, array.length - 1);
        }

        if (firstIndex > -1 && lastIndex > -1) {
            number = lastIndex - firstIndex + 1;

        }

        return number;
    }

    private int getFirstK(int[] data, int k, int start, int end) {

        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIndex = start + (end - start) / 2;

        int midData = data[midIndex];

        if (midData == k) {
            if (midIndex > 0 && data[midIndex - 1] != k || midIndex == 0) {
                return midIndex;
            } else {
                end = midIndex - 1;
            }
        } else if (midData > k) {
            end = midIndex - 1;
        } else {
            start = midIndex + 1;
        }

        return getFirstK(data, k, start, end);
    }


    private int getLastK(int[] data, int k, int start, int end) {
        if (data == null || data.length < 1 || start > end) {
            return -1;
        }

        int midIndex = start + (end - start) / 2;
        int midData = data[midIndex];

        if (midData == k) {
            if (midIndex < data.length - 1 && data[midIndex + 1] != k || midIndex == data.length - 1) {
                return midIndex;
            } else {
                start = midIndex + 1;
            }
        } else if (midData < k) {
            start = midIndex + 1;

        } else {
            end = midIndex - 1;
        }

        return getLastK(data, k, start, end);
    }

    @Test
    public void Test() {
//        int[] array = {1,2,3,3,3,4,5};
        int[] array = {3, 3, 3, 3, 4, 5};
        getNumberOfK(array, 3);
    }
}

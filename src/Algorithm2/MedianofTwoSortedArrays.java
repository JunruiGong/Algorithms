package Algorithm2;

import org.junit.Test;

/**
 * Leetcode-4-Median of Two Sorted Arrays-Hard
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // 将两个数组中的数放入一个新的数组中
        // 找到中位数
        int[] array = new int[nums1.length + nums2.length];

        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] <= nums2[index2]) {
                array[index++] = nums1[index1++];
            } else {
                array[index++] = nums2[index2++];
            }
        }

        if (index1 < nums1.length) {
            for (int i = index; i < array.length; i++) {
                array[i] = nums1[index1++];
            }
        }

        if (index2 < nums2.length) {
            for (int i = index; i < array.length; i++) {
                array[i] = nums2[index2++];
            }
        }

        if (array.length % 2 == 0) {

            double first = array[(array.length - 1) / 2];
            double second = array[array.length / 2];
            return (first + second) / 2;
        } else {
            return array[array.length / 2];
        }
    }


    @Test
    public void test(){
        int[] nums1={3};
        int[] nums2={-2,-1};

        System.out.println(findMedianSortedArrays(nums1,nums2));

    }
}
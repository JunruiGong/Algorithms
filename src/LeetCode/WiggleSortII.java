package LeetCode;

import org.junit.Test;

import java.util.Arrays;

/**
 * Leetcode-324-Wiggle Sort II-Medium
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 *
 * Example 2:
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        // 先将数组排序
        Arrays.sort(nums);

        int n = nums.length;

        // 确定中点
        int mid = (n - 1) / 2;

        // 找到中点之后，将数组分为前后两个部分
        // 取前一部分的最后一个点和后一部分最后一个点放入temp中
        // 再取前一部分倒数第二个点和后一部分倒数第二个点放入temp中
        // 依次操作，这样就能是数组符合题目要求排序

        int[] temp = new int[nums.length];

        int index = 0;
        for (int i = 0; i <= mid; i++) {

            temp[index] = nums[mid - i];

            if (index + 1 < n) {
                temp[index + 1] = nums[n - i - 1];
            }
            index = index + 2;
        }

        // 将排完序的数组复制到愿数组中
        System.arraycopy(temp, 0, nums, 0, n);

    }


    @Test
    public void test(){
        int[] nums = {1,5,1,1,6,4};
       // int[] nums = {1};

        wiggleSort(nums);
    }

}

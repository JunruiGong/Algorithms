package LeetCode;

import org.junit.Test;

/**
 * Leetcode-75-Sort Colors
 *
 * Given an array with n objects colored red, white or blue,
 * sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *
 * Input: [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Follow up:
 *
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with a one-pass algorithm using only constant space?
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 1) {
            return;
        }

        // 分别用left，index，right来储存0，1，2
        int left = 0;
        int index = 0;
        int right = nums.length-1;

        while (index <= right) {
            if (nums[index] == 0) {
                //当数为0时，将该数放在最左边
                swap(nums, index++, left++);
            } else if (nums[index] == 1) {
                //当数为1时，不变
                index++;
            } else {
                // 当数为2时，将其放在最右边
                swap(nums, index, right--);
            }
        }

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void Test(){
        int[] nums ={2,0,2,1,1,0};
        sortColors(nums);

    }
}

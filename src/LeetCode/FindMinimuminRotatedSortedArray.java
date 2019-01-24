package LeetCode;

/**
 * Leetcode-153-Search in Rotated Sorted Array-Medium
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {

        // 该题的思路是一直循环找到旋转的位置，该位置上的值一定是最小的

        if (nums == null || nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            // 找到了旋转点，该点的值是最小的
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // 如果mid的值大于start和end，则说明最小值位于mid的右边
            if (nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                //否则mid的值小于start和end，则说明最小值位于mid的左边边
                end = mid - 1;
            }
        }

        return nums[start];
    }
}

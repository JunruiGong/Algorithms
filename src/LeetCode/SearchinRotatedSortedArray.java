package LeetCode;

/**
 * Leetcode-33-Search in Rotated Sorted Array-Medium
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            // 说明[start, mid]是一个递增序列
            if (nums[start] < nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    // 判断target是否在这个序列之间
                    end = mid;
                } else {
                    // 否则从mid之后的序列中查找
                    start = mid;
                }
            } else {
                // 说明[start, mid]不是一个递增的序列，中间有旋转。无法在[start, mid]中查找
                // 由于只有一个位置有旋转(start与mid之间)，所以在[mid, end]区间，一定是递增序列
                if (nums[mid] <= target && target <= nums[end]) {
                    // 判断target是否在这个序列之间
                    start = mid;
                } else {
                    // 否则在[start, mid]中间仔寻找
                    end = mid;
                }
            }
        }

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }

        // 没找到target，return -1
        return -1;
    }
}

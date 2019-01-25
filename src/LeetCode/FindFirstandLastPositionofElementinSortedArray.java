package LeetCode;


import org.junit.Test;

/**
 * Leetcode-34-Find First and Last Position of Element in Sorted Array-Medium
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length < 1) {
            return new int[]{-1, -1};
        }

        int start = findFirst(nums, target);
        if (start == -1) {
            return new int[]{-1, -1};
        }

        int end = findLast(nums, target);
        return new int[]{start, end};


    }

    private int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    private int findLast(int nums[], int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (nums[end] == target) {
            return end;
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }

    @Test
    public void test() {

        int[] nums = {2,2};
        int target = 2;
        System.out.println(searchRange(nums, target));

    }
}
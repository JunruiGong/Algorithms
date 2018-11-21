package LeetCode;

/**
 * Leetcode-80-Remove Duplicates from Sorted Array II
 * <p>
 * Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */

public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {

        if (nums.length <= 2) {
            return nums.length;
        }

        int count = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}

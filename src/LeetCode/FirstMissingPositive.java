package LeetCode;

/**
 * Leetcode-41-First Missing Positive
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example:
 * Input: [1,2,0]
 * Output: 3
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {

            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;

    }
}

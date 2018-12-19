package LeetCode;

import org.junit.Test;

/**
 * Leetcode-152-Maximum Product Subarray
 *
 * Given an integer array nums,
 * find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int result = 0;
        int max = nums[0];
        int min = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // 遇到负数，需要交换
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }

            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);
            result = Math.max(max, result);
        }
        return result;
    }

    @Test
    public void Test(){
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}

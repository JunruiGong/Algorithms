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

    // DP
    public int maxProduct2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int result = nums[0];

        // 保存计算到index为止的最小值
        int[] min = new int[nums.length];

        // 保存计算到index为止的最大值
        int[] max = new int[nums.length];

        min[0] = nums[0];
        max[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // 因为nums[i]可能出现正数和负数，两个负数相乘为正数
            // 所以需要在nums[i], min[i - 1] * nums[i], max[i - 1] * nums[i]三者间比较
            min[i] = Math.min(nums[i], Math.min(min[i - 1] * nums[i], max[i - 1] * nums[i]));

            // 最大值同理
            max[i] = Math.max(nums[i], Math.max(max[i - 1] * nums[i], min[i - 1] * nums[i]));

            result = Math.max(result, max[i]);
        }

        return result;
    }

    // DP，但是优化了存储空间，本质上与上面一种方法相同
    public int maxProduct3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int result = nums[0];

        int min = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int k = min * nums[i]; // 此时的min相当于计算到i-1为止的最小值
            int m = max * nums[i]; // 此时的max相当于计算到i-1为止的最大值

            min = Math.min(nums[i], Math.min(k, m));
            max = Math.max(nums[i], Math.max(k, m));

            result = Math.max(result, max);
        }

        return result;
    }



    @Test
    public void Test(){
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}

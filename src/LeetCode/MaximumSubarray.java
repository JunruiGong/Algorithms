package LeetCode;

import org.junit.Test;

/**
 * Leetcode-53-Maximum Subarray
 *
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 * */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];

        int result = dp[0];
        for (int i = 1; i < nums.length; i++) {

            // 如果前一个数小于0，则我们就不用从前面开始加了，
            // 因为加上负数之后的和，肯定比本身要小
            // 直接从当前数开始加，相当于起始位置从i开始
            if (dp[i - 1] < 0) {
                dp[i] = nums[i];
            } else {
                dp[i] = nums[i] + dp[i - 1];
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }

    @Test
    public void Test() {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }
}

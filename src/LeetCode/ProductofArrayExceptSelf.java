package LeetCode;

import org.junit.Test;

/**
 * Leetcode-238-Product of Array Except Self
 *
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity?
 * (The output array does not count as extra space for the purpose of space complexity analysis.)
 * */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 1) {
            return nums;
        }

        int[] result = new int[nums.length];
        result[0] = 1;

        // 先计算每个数左边的乘积
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        // 再计算每个数右边的乘积
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {

            result[i] = result[i] * right;
            right = right * nums[i];
        }

        return result;
    }

    @Test
    public void Test(){
        int[] nums = {1,2,3,4};
        System.out.println(productExceptSelf(nums));

    }
}

package LeetCode;


import org.junit.Test;

/**
 * Leetcode-209-Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 * */
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {

        int result = Integer.MAX_VALUE;
        int left = 0;   // 表示从第left位开始相加
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                // 如果sum大于s，则判断当前subArray的长度(i - left + 1)与之前的result的大小
                result = Math.min(result, i - left + 1);

                //sum减去最开始的num，起始位置+1
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;

    }

    @Test
    public void Test(){
        int[] nums ={2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7,nums));

    }
}

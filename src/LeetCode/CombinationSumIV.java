package LeetCode;

import java.util.Arrays;

/**
 * Leetcode-377-Combinations Sum IV-Medium
 *
 * Given an integer array with all positive numbers and no duplicates,
 * find the number of possible combinations that add up to a positive integer target.
 *
 * Example:
 *
 * nums = [1, 2, 3]
 * target = 4
 *
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 *
 * Note that different sequences are counted as different combinations.
 *
 * Therefore the output is 7.
 */
public class CombinationSumIV {

    // 假设target是4，而4可以从3+1，2+2，1+3得到4
    // 所以问题就变成求组合成3，2，1的所有情况
    // 计算上述情况总和，就得到组合成4的所有情况

    // Back Tracking
    // 时间复杂度较高，超时
    public int combinationSum4(int[] nums, int target) {

        // target=0，只有一种情况
        if (target == 0) {
            return 1;
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {  // 为什么需要判断target >= nums[i]？ 这样说明nums中至少还是有数字可以组合成target的
                result += combinationSum4(nums, target - nums[i]);
            }
        }

        return result;
    }

    // DP
    private int[] dp;

    public int combinationSum4DP(int[] nums, int target) {
        dp = new int[target + 1];

        Arrays.fill(dp, -1);  // 初始化dp[] 都为-1

        dp[0] = 1;
        return help(nums, target);
    }

    private int help(int[] nums, int target) {
        if (dp[target] != -1) { // 不为-1，说明已经计算过，直接返回结果
            return dp[target];
        }

        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += help(nums, target - nums[i]);
            }
        }

        dp[target] = result; // 记录到达当前target的所有组合数量
        return result;
    }
}

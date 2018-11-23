package LeetCode;

import org.junit.Test;

/**
 * Leetcode-45-Jump Game II
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 我们假设当前能够跳跃的范围是[curBegin,curEnd],
        // curFarthest是在跳跃范围内能够到达的最远的点，
        // 当index到达curEnd, 我们将curFarthest设为新的curEnd，以此类推。
        int result = 0;
        int curEnd = 0;
        int curFarthest = 0;

        // i最多遍历到nums.length-1，如果到nums.length，result会加一，结果不正确。
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(nums[i] + i, curFarthest);
            if (i == curEnd) {
                result++;
                curEnd = curFarthest;

            }
        }
        return result;
    }


    // BFS的思想解决
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }

        int i = 0;
        int level = 0;
        int curEnd = 0;
        int curFarthest = 0;
        while (curEnd - i + 1 > 0) {
            level++;
            for (; i <= curEnd; i++) {
                curFarthest = Math.max(curFarthest, nums[i] + i);
                if (curFarthest >= nums.length - 1) {
                    return level;
                }

            }
            curEnd = curFarthest;
        }

        return 0;
    }


    @Test
    public void Test(){

        int[] nums={2,3,1,1,4};

        jump(nums);

    }
}

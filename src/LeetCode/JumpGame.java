package LeetCode;

/**
 * Leetcode-55-Jump Game
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {

        int max = 0;  // 表示当前能走到的最远的index
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                // 如果当前的index比当前能走的最远的index大，则说明无法到达。
                return false;
            }

            // nums[i] + i 表示当前能走到的最远的index
            max = Math.max(nums[i] + i, max);
        }

        return true;
    }
}

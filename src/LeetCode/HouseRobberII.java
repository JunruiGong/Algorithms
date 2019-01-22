package LeetCode;

/**
 * Leetcode-213-House Robber II-Medium
 *
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed.
 * All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile,
 * adjacent houses have security system connected and
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 *
 * Example 1:
 * Input: [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
 *              because they are adjacent houses.
 *
 * Example 2:
 * Input: [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 *              Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRobberII {
    public int rob(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        // 如果从第0位开始，则到nums.length-2就结束
        // 如果从第1位开始，则到nums.length-1结束
        // 取两者的最大值
        return Math.max(help(nums, 0, nums.length - 2), help(nums, 1, nums.length - 1));
    }


    // 这个函数是从Leetcode-198修改过来的
    private int help(int[] nums, int lo, int hi) {
        int prevNo = 0;
        int prevYes = 0;
        for (int j = lo; j <= hi; j++) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = nums[j] + temp;
        }

        return Math.max(prevYes, prevNo);
    }
}

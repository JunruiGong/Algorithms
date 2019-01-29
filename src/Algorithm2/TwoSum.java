package Algorithm2;

import java.util.HashMap;

/**
 * Leetcode-1-Two Sum-Easy
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int a = target - nums[i];
            if (map.containsKey(a)) {
                result[1] = i;
                result[0] = map.get(a);
                break;
            }
            map.put(nums[i], i);
        }

        return result;
    }
}
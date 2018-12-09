package LeetCode;

import java.util.HashSet;

/**
 * Leetcode-128-Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int num : nums) {
            hashSet.add(num);
        }

        int result = 0;


        // 直接遍历hashSet，hashSet里面的数是排好序的
        for (int num : hashSet) {
            int down = num - 1;
            if (!hashSet.contains(down)) {
                int up = num + 1;
                while (hashSet.contains(up)) {
                    up++;
                }
                result = Math.max(result, up - num);
            }
        }
        return result;
    }
}

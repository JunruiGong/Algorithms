package LeetCode;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Leetcode-239-Sliding Window Maximum
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 * You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.
 *
 * Example:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 * Output: [3,3,5,5,6,7]
 *
 * Explanation:
 *
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.
 *
 * Follow up:
 * Could you solve it in linear time?
 * */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return new int[0];
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        int max;
        int[] result = new int[nums.length + 1 - k];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);

            if (i == k - 1) {
                result[index++] = queue.peek();
            }
            if (queue.size() > k) {
                queue.remove(nums[i - k]);
                result[index++] = queue.peek();
            }
        }
        return result;
    }
}

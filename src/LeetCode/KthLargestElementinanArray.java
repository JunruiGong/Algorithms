package LeetCode;

import java.util.PriorityQueue;

/**
 * Leetcode-215-Kth Largest Element in an Array-Medium
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        if (nums == null || nums.length < 1) {
            return 0;
        }

        for (int num : nums) {
            queue.add(num);
        }

        while (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();
    }
}

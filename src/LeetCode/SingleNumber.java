package LeetCode;

/**
 * Leetcode-136-Single Number-Easy
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;

        // 异或：两个数相同为0，不同为1
        // 一个数异或另外一个数两次，不会改变原先的那个数：a ^ b ^ b = a
        // a number XOR by another number twice makes no change on original number, a ^ b ^ b = a
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
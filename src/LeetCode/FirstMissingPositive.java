package LeetCode;

import org.junit.Test;

/**
 * Leetcode-41-First Missing Positive
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example:
 * Input: [1,2,0]
 * Output: 3
 * <p>
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * Input: [7,8,9,11,12]
 * Output: 1
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {


        // 根据桶排序的方式，对应的位置放对应的数，
        // 1要放在1的位置，2要放在2的位置，以此类推。
        // [3,4,-1,1]  原始
        // [1,-1,3,4]  排序之后
        // 排序之后从前往后遍历，找到第一个位置与数不相符的数即可。

        if (nums == null || nums.length == 0) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {

            // nums[nums[i] - 1] != nums[i]
            // 这个条件用来判断该数是不是在对应的位置上
            // 如果不是，就将该数交换到对应的位置上

            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i : nums) {
            System.out.println(i);

        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return nums.length + 1;

    }

    @Test
    public void Test() {

        int[] nums = {99, 87, 2, 56};
        firstMissingPositive(nums);

    }
}

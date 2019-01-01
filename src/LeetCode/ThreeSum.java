package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode-15-3Sum-Medium
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // 去除重复的数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];  // 先确定一个数，再判断另外两个数

            while (low < high) {
                if (nums[low] + nums[high] == sum) {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                    // 因为排完序之后，相邻的数可能相等，但是结果中不需要保存相同的答案。
                    while (low < high && nums[low] == nums[low+1]) {
                        low++;
                    }
                    while (low < high && nums[high] == nums[high-1]) {
                        high--;
                    }

                    low++;
                    high--;
                } else if (nums[low] + nums[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }

        return result;
    }

    @Test
    public void test(){
        int[] nums = {-1,0,1,2,-1,-4};

        System.out.println(threeSum(nums));

    }
}

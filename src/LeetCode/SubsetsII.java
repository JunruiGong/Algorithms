package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode-90-Subsets II-Medium
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 */
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }

        Arrays.sort(nums);
        help(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void help(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                // 去重操作
                continue;
            }

            list.add(nums[i]);
            help(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

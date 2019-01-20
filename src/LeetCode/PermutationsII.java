package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode-47-Permutations II-Medium
 *
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 *
 * Example:
 *
 * Input: [1,1,2]
 * Output:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }

        Arrays.sort(nums);
        help(result, new ArrayList<>(), nums, new boolean[nums.length]);
        return result;

    }

    private void help(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] used) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 当该数已经使用过，或者该数与前一个数相同且前一个数没有使用过
                // 这两种情况下需要去重
                // 假如相同的数都使用过了，那组合成的数必定是unique的，则不需要去重
                continue;
            }
            used[i] = true;
            list.add(nums[i]);
            help(result, list, nums, used);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }
}

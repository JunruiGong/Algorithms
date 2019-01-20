package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-39-Combinations Sum-Medium
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 *
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        // 参考借鉴Leetcode-78/90

        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length < 1) {
            return result;
        }

        help(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void help(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            help(result, list, candidates, target - candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}

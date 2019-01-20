package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-78-Subsets-Medium
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }

        help(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private static void help(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<>(list));
        System.out.println(result);

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            System.out.println(list);
            help(result, list, nums, i + 1);
            list.remove(list.size() - 1);
            System.out.println(list);
        }
    }

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

}

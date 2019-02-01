package Algorithm2;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-163-Missing Ranges
 *
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75],lower = 0, upper = 99, return [“2”, “4->49”, “51->74”, “76->99”]
 */
public class MissingRanges {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();

        if (nums == null || nums.length < 1) {
            return result;
        }

        if (lower < nums[0] - 1) {
            String temp = lower + "->" + (nums[0] - 1);
            result.add(temp);
        }


        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i] + 1) {
                String temp = (nums[i - 1] + 1) + "->" + (nums[i] - 1);
                result.add(temp);
            }
        }

        if (upper > nums[nums.length] + 1) {
            String temp = (nums[nums.length] + 1) + "->" + upper;
            result.add(temp);
        }

        return result;
    }
}

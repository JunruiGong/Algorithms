package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-254-Factor Combinations-Medium
 *
 * Numbers can be regarded as product of its factors. For example,
 *
 * 8 = 2 x 2 x 2;
 *   = 2 x 4.
 * Write a function that takes an integer n and return all possible combinations of its factors.
 *
 * Note:
 *
 * Each combination's factors must be sorted ascending, for example: The factors of 2 and 6 is [2, 6], not [6, 2].
 * You may assume that n is always positive.
 * Factors should be greater than 1 and less than n.
 *
 *
 * Examples:
 * input: 1
 * output:
 * []
 *
 * input: 37
 * output:
 * []
 *
 * input: 12
 * output:
 * [
 *   [2, 6],
 *   [2, 2, 3],
 *   [3, 4]
 * ]
 *
 * input: 32
 * output:
 * [
 *   [2, 16],
 *   [2, 2, 8],
 *   [2, 2, 2, 4],
 *   [2, 2, 2, 2, 2],
 *   [2, 4, 4],
 *   [4, 8]
 * ]
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        help(result, new ArrayList<>(), n, 2);  // 数字本身和1不计算在内，所以从2开始
        return result;
    }

    private void help(List<List<Integer>> result, List<Integer> list, int n, int start) {
        if (n == 1) {
            if (list.size()>1){
                result.add(new ArrayList<>(list));
            }
        }

        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                list.add(i);
                help(result, list, n / i, i);  // 因为因子可以重复，所以start不需要++
                list.remove(list.size() - 1);
            }
        }
    }


    @Test
    public void test(){
        System.out.println(getFactors(32));
    }
}

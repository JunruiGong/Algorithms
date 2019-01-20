package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-77-Combinations-Medium
 *
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 *
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        help(result, new ArrayList<>(), n, k, 1);
        return result;
    }

    private void help(List<List<Integer>> result, List<Integer> list, int n, int k, int start) {

        // k 代表需要缺失的个数
        // 当k=0时，表示已经达到缺失的个数
        if (k == 0) {
            result.add(new ArrayList<>(list));
            System.out.println(result);
        }

        for (int i = start; i <= n; i++) {
            list.add(i);
            System.out.println(list);
            help(result, list, n, k - 1, i + 1);
            list.remove(list.size() - 1);
            System.out.println(list);
        }
    }

    @Test
    public void test(){
        System.out.println(combine(4,2));
    }
}

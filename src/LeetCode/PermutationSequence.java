package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-60-Permutation Sequence-Medium
 *
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 *
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 *
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 *
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */
public class PermutationSequence {
    public String getPermutation(int n, int k) {
        List<Integer> result = new ArrayList<>();

        // 将1, 2, 3..., n添加到result中
        for (int i = 1; i <= n; i++) {
            result.add(i);
        }

        // fact表示不同位数的全排列数量
        // 如: 1位数，全排列有1种
        //     2位数，全排列有2种
        //     3位数，全排列有6种
        //     4位数，全排列有24种
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = i * fact[i - 1];
        }

        k--; // 从0开始计算，k要先减1

        StringBuilder sb = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / fact[i - 1];
            k = k % fact[i - 1];
            sb.append(result.get(index));
            result.remove(index);  // 因为每个数只能使用一次，所以每次用完之后要删除
        }

        return sb.toString();
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-22-Generate Parentheses-Medium
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {

        // Backtracking

        List<String> result = new ArrayList<>();
        if (n == 0) {
            return result;
        }

        helper(result, "", n, n);

        return result;

    }

    private void helper(List<String> result, String s, int left, int right) {

        // left,right 表示剩余左括号和右括号的个数
        if (left > right) {
            // 如果left>right，如："(()))"，则一定无法组成合法的括号
            return;
        }

        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0) {
            helper(result, s + "(", left - 1, right);
        }

        if (right > 0) {
            helper(result, s + ")", left, right - 1);
        }

    }
}

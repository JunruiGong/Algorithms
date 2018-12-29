package LeetCode;

import java.util.Stack;

/**
 * Leetcode-32-Longest Valid Parentheses-Hard
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 *
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 *
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int start = -1;  // 合法括号的起始index
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    // 当起始的括号为右括号时，一定是不合法的，直接跳过
                    start = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        // ")()())"
                        result = Math.max(result, i - start);
                    } else {
                        // "(())"
                        result = Math.max(result, i - stack.peek());
                    }
                }
            }
        }

        return result;
    }
}

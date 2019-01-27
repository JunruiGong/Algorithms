package LeetCode;

import java.util.Stack;

/**
 * Leetcode-227-Basic Calculator II-Hard
 *
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: "3+2*2"
 * Output: 7
 *
 * Example 2:
 * Input: " 3/2 "
 * Output: 1
 *
 * Example 3:
 * Input: " 3+5 / 2 "
 * Output: 5
 *
 * Note:
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = 10 * num + (c - '0');
            }
            if (!Character.isDigit(c) && ' ' != s.charAt(i) || i == s.length() - 1) {
                // 如果c是运算符或者i已经遍历到最后
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = s.charAt(i);
                num = 0;
            }
        }

        int result = 0;
        for (int i : stack) {
            result += i;
        }

        return result;
    }
}

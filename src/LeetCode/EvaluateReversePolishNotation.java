package LeetCode;

import java.util.Stack;

/**
 * Leetcode-150-Evaluate Reverse Polish Notation-Medium
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 *
 * Example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {

        int a, b;

        Stack<Integer> stack = new Stack<>();

        for (String str : tokens) {
            if (str.equals("+")) {
                // 取出最上面的两个数相加后push至stack中
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("/")) {
                // 因为除法是有除数和被除数之分
                // 所以需要确定这两个数哪个是除数，哪个是被除数
                b = stack.pop();
                a = stack.pop();
                stack.push(a / b);
            } else if (str.equals("-")) {
                b = stack.pop();
                a = stack.pop();
                stack.push(a - b);
            } else if (str.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else {
                // 为数字，直接push
                stack.push(Integer.parseInt(str));
            }
        }

        return stack.pop();

    }
}
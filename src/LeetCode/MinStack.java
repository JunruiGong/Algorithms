package LeetCode;

import java.util.Stack;

/**
 * Leetcode-155-Min Stack-Easy
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<Integer>();

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();

    }

    public void push(int x) {

        // 当插入的值x小于min时，
        // 先将min插入stack，并将min赋为x
        if (x <= min) {
            stack.push(min);
            min = x;
        }

        // 再将x插入
        stack.push(x);

    }

    public void pop() {

        // 如果取出的值与最小值相等
        // 则我们需要再次pop，并改变最小值（每个值在push时都会保存两遍）
        if (stack.pop() == min) {
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min;
    }

}

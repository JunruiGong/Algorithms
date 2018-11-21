package CodingInterviews;

/**
 * 剑指offer-22-栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *（注意：这两个序列的长度是相等的）
 *
 * */

import java.util.Stack;

public class StackPushPopSequence {

    /*
    * 规律：
    * 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出；
    * 如果下一个弹出的数字不在栈顶，则把压栈序列中还没有入栈的数字压入辅助栈，
    * 知道把下一个需要弹出的数字压入栈顶为止。
    * 最后判断辅助栈是否为空，为空证明符合出栈序列，返回true。
    *
    * */

    public boolean IsPopOrder(int[] pushA, int[] popA) {

        if (pushA.length != popA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while ((!stack.isEmpty() && (stack.peek() == popA[j]))) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }
}

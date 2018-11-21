package CodingInterviews;


import java.util.Stack;

/**
 * 剑指offer-21-包含min函数的栈
 *定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * */
public class minStack {

    /*
    * 借助两个栈来实现，一个栈存放数据，另一个栈只存放最小值（辅助栈）。
    * 每次插入数据，需要判断该数是否是最小值。
    * 是的话，需要将在两个栈中都插入该值；
    * 不是的话，需要在辅助栈中插入之前的最小值。
    *
    * */

    private Stack<Integer> data = new Stack<Integer>();
    private Stack<Integer> min = new Stack<Integer>();

    public void push(int node) {

        data.push(node);
        if (min.isEmpty()) {
            min.push(node);
        } else if (node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {

        return min.peek();
    }
}

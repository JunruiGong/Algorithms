package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-42-左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotateString {

    public String leftRotateString(String str,int n) {
        if(str==null || n <1 || n>str.length()){
            return "";
        }

        String head = str.substring(n);

        String tail = str.substring(0,n);

        return head+tail;
    }

    @Test
    public void Test(){

        String str = "abcdef";
        leftRotateString(str,3);

    }
}

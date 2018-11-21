package CodingInterviews;

/**
 * 剑指offer-47-不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public int add(int num1, int num2) {

        // 使用二进制进行计算
        // 使用异或模拟不带进位的加法
        // 再将两数进行与，并左移一位，得到需要进位的位置
        // 重复上述步骤，知道没有进位

        int sum;
        int carry;

        do {
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);

        return num1;

    }
}

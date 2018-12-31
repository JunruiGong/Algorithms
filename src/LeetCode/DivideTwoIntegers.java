package LeetCode;

import org.junit.Test;

/**
 * Leetcode-29-Divide Two Integers-Medium
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 *
 * Return the quotient after dividing dividend by divisor.
 *
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 *
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment
 * which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int sign = 1;

        // 判断正负号
        if ((dividend > 0 && divisor < 0) || dividend < 0 && divisor > 0) {
            sign = -1;
        }
        long ldividend =  Math.abs((long)dividend);
        long ldivisor =Math.abs((long)divisor);

        // 被除数是0的情况和被除数小于除数的情况
        if (ldividend == 0 || (ldividend < ldivisor)) {
            return 0;
        }

        long lres = divide(ldividend, ldivisor);
        int result = 0;
        if (lres > Integer.MAX_VALUE) {
            result = sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            result = (int) (sign * lres);
        }

        return result;
    }


    private long divide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }

        long sum = ldivisor;
        long multiple = 1;

        while ((sum + sum) < ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + divide(ldividend - sum, ldivisor);

    }

    @Test
    public void test(){
        int dividend = -2147483648;
        int divisor = -1;
        System.out.println(divide(dividend,divisor));
    }
}

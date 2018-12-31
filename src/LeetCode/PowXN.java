package LeetCode;

/**
 * Leetcode-50-Pow(x, n)-Easy
 *
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 *
 * Example 1:
 * Input: 2.00000, 10
 * Output: 1024.00000
 *
 * Example 2:
 * Input: 2.10000, 3
 * Output: 9.26100
 *
 * Example 3:
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 *
 * Note:
 *
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−2^31, 2^31 − 1]
 *
 * eg: 2^2 = 2^1 * 2^1 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) = 4
 *     2^3 = 2^1 * 2^1 * 2 = (2^0 * 2^0 * 2) * (2^0 * 2^0 * 2) * 2 = 8
 */
public class PowXN {
    public double myPow(double x, int m) {
        double temp;
        if (m == 0)
            return 1;
        temp = myPow(x, m / 2);
        if (m % 2 == 0)
            return temp * temp;
        else {
            if (m > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }

    public double myPow2(double x, int m) {

        if (m == 0) {
            return 1;
        }

        double result = 1;
        long abs = Math.abs((long) m);
        while (abs > 0) {
            // 奇数次幂, 先乘一个x
            if (abs % 2 != 0) {
                result *= x;
            }

            x *= x;
            abs /= 2;
        }
        if (m < 0) {
            return 1.0 / result;
        }

        return result;
    }

}

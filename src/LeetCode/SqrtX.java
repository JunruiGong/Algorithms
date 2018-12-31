package LeetCode;

/**
 * Leetcode-69-Sqrt(x)-Easy
 *
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x < 0) {
            return 0;
        }

        int low = 1;
        int high = x;

        // 二分法
        while (low < high) {
            long mid = (high - low) / 2;
            if (mid * mid < x) {
                low = (int) mid + 1;
            } else if (mid * mid > x) {
                high = (int) mid - 1;
            }
        }

        // 有可能不能完全开平方，如sqrt(8)=2.82...
        // 这个时候只能取2
        if (high * high < x) {
            return high;
        } else {
            return low;
        }
    }
}

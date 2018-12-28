package LeetCode;

import org.junit.Test;

/**
 * Leetcode-9-Palindrome Number-Easy
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 * Input: 121
 * Output: true
 *
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        char[] c = String.valueOf(x).toCharArray();
        int start = 0;
        int end = c.length-1;

        while (start <= end) {
            if (c[start] != c[end]) {
                return false;
            } else {
                start++;
                end--;
            }
        }

        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) {  // 如果x是10的倍数，则一定不对称
            return false;
        }

        int result = 0;

        while (result < x) {
            // 从后往前依次取出x在各个位置上的数，并添加到result中

            result = result * 10 + x % 10;
            x = x / 10;
        }

        // 如果两个相等或x == result / 10，则x是对称的
        return (x == result || x == result / 10);
    }

    @Test
    public void test(){
        int x = 121;
        System.out.println(isPalindrome(x));
    }
}

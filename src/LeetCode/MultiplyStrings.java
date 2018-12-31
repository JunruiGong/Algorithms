package LeetCode;

import org.junit.Test;

/**
 * Leetcode-43-Add Binary-Medium
 *
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 *
 * Graph Explanation:
 * https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 */
public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        if (num1 == null || num1.length() < 1 || num2 == null || num2.length() < 1) {
            return "0";
        }

        // 乘积的长度等于两个乘数长度的和
        int[] digits = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            for (int j = num2.length() - 1; j >= 0; j--) {

                // 每一位进行相乘
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // 相乘之后的十位
                int p1 = i + j;

                // 相乘之后的个位
                int p2 = i + j + 1;
                int sum = product + digits[p2];

                // 相乘之后的进位放在p1的位置上
                digits[p1] += sum / 10;

                // 剩余的数放在p2的位置上
                digits[p2] = sum % 10;
            }
        }

        StringBuilder result = new StringBuilder();


        // 组合digits
        for (int digit : digits) {
            if (digit == 0 && result.length() == 0) {
                continue;
            }else{
                result.append(digit);
            }
        }

        return result.length() == 0 ? "0" : result.toString();
    }

    @Test
    public void test(){
        String num1 ="2";
        String num2 ="3";
        System.out.println(multiply(num1,num2));

    }
}

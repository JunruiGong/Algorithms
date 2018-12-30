package LeetCode;

/**
 * Leetcode-67-Add Binary-Easy
 *
 * Given two binary strings, return their sum (also a binary string).
 *
 * The input strings are both non-empty and contains only characters 1 or 0.
 *
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 *
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if (a == null || a.length() < 1 || b == null || b.length() < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;  // 进位
        while (i >= 0 || j >= 0) {
            int sum = carry; // 上一次的进位
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            sb.append(sum % 2);  // 两种情况：0或1
            carry = sum / 2; // 只有在sum = 2 的情况下才有进位
        }

        if (carry != 0) {
            // 循环结束之后，还有进位，则长度加1
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}

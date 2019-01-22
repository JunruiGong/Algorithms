package LeetCode;

/**
 * Leetcode-91-Decode Ways-Medium
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        int dp[] = new int[s.length() + 1];
        dp[0] = 1;

        // 第一位数如果为0，则没有对应的字母，则dp[1]=0
        // 如果不为0，则只有一种可能
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {

            // 1～9
            int first = Integer.valueOf(s.substring(i - 1, i));

            // 10～26
            int second = Integer.valueOf(s.substring(i - 2, i));

            if (first >= 1 && first <= 9) {
                dp[i] = dp[i] + dp[i - 1];
            }

            if (second >= 10 && second <= 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}

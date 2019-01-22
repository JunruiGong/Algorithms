package LeetCode;

import org.junit.Test;

/**
 * Leetcode-97-Interleaving String-Hard
 *
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example 1:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * Output: true
 * Example 2:
 *
 * Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * Output: false
 *
 *
 * s1 = "aabcc"
 * s2 = "dbbca"
 * s3 = "aadbbcbcac", return true
 *
 *                      s1
 *      [true, true, true, false, false, false]
 *      [false, false, true, true, false, false]
 *  s2  [false, false, true, true, true, false]
 *      [false, false, true, false, true, true]
 *      [false, false, true, true, true, false]
 *      [false, false, false, false, true, true]
 *
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        boolean dp[][] = new boolean[s2.length() + 1][s1.length() + 1];

        dp[0][0] = true;

        // 第一列s2中每个字符与对应s3的字符是否相同
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        // 第一行s1中每个字符与对应s3的字符是否相同
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = (dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1));
                System.out.println(dp[i][j]);
            }
        }

        return dp[s2.length()][s1.length()];
    }

    @Test
    public void test() {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));
    }
}

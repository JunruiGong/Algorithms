package LeetCode;

/**
 * Leetcode-10-Regular Expression Matching-Hard
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
 *
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 *
 *
 * dp[i][j]: 表示s[0-i]与p[0-j]是否匹配
 *
 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];  // 两个字符相同
 * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];  // "." 可以为任意字符
 * 3, If p.charAt(j) == '*':
 *    here are two sub conditions:
 *                1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
 *                      // 上面这种情况对应的是："baab" 与 "bc*aab"
 *                      // 第j位为"*"，则看第j-1位，如果 p.charAt(j-1) != s.charAt(i)
 *                      // 则删除第j-1和j位的字符
 *
 *
 *                      // s: "aa"  p: ".*" 或 "a*"
 *                2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
 *                               dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
 *                            or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
 *                            or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
 *
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        //  初始化第一行，如果第i这个位置为"*"，则根据题意，可以复制成前一个字符
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
}
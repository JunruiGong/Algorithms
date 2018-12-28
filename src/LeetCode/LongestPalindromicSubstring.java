package LeetCode;

/**
 * Leetcode-5-Longest Palindromic Substring-Medium
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {

    // time: O(n^2) space: O(n^2)
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return s;
        }

        String result = "";
        int max = 0;

        boolean[][] dp = new boolean[s.length()][s.length()];

        // j: 字符串的结尾index
        // i: 字符串的开头index
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {

                // 判断当前位置i与j上的字符是否相等
                // 同时还要判断中间的字符是否满足条件
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);

                if (dp[i][j]) { // 如果是回文
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }

        return result;
    }


    String result = "";

    // time: O(n^2) space: O(n)
    // 中心扩散的思想
    // 从中间开始，向两边扩散，依次判断两边的字符是否相等
    public String longestPalindrome2(String s) {

        if (s == null || s.length() < 1) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            help(s, i, i);   // substring长度为奇数
            help(s, i, i + 1);  // substring长度为偶数
        }

        return result;
    }

    private void help(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        String currentStr = s.substring(left + 1, right);


        if (currentStr.length() > result.length()) {
            result = currentStr;
        }
    }
}

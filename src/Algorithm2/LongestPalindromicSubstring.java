package Algorithm2;

import org.junit.Test;

/**
 * Leetcode-5-Longest Palindromic Substring-Medium
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 * */
public class LongestPalindromicSubstring {
    String result = "";

    // time: O(n^2) space: O(n)
    // 中心扩散的思想
    // 从中间开始，向两边扩散，依次判断两边的字符是否相等
    public String longestPalindrome(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {

            help(s, i, i + 1); // 长度为偶数
            help(s, i, i);  // 长度为奇数
        }

        return result;

    }

    private void help(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // left可能会到达-1，所以需要+1
        String currString = s.substring(left + 1, right);

        if (currString.length() > result.length()) {
            result = currString;
        }
    }

    @Test
    public void test(){
        String s="babad";
        System.out.println(longestPalindrome(s));

    }

}
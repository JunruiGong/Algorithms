package LeetCode;

import org.junit.Test;

/**
 * Leetcode-159-Longest Substring with At Most Two Distinct Characters
 *
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * For example,
 * Given S = “eceba”,
 * T is “ece” which its length is 3.
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int left = 0;  // 表示substring的左边界
        int second = -1;
        int len = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // 如果相邻两个字符相同，则可以忽略
                continue;
            }

            // 当第i个数于其前一个字符不相同，则说明出现了两个不相同的字符
            // 此时需要记录长度
            if (second >= 0 && s.charAt(i) != s.charAt(second - 1)) {
                len = Math.max(len, i - left);
                left = second + 1;
            }

            second = i - 1;
        }

        return Math.max(len, s.length() - left);
    }

    @Test
    public void Test() {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringTwoDistinct(s));

    }
}

package LeetCode;

import org.junit.Test;

/**
 * Leetcode-76-Minimum Window Substring
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example:
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the empty string "".
 * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] count = new int[128];

        for (char c : t.toCharArray()) {
            count[c]++;
        }

        int from = 0;  // 记录起始的index
        int min = Integer.MAX_VALUE;  // 记录满足条件时的最小长度
        int total = t.length();

        // j表示起始index，i表示结束index
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (count[s.charAt(i)]-- > 0) {
                // 判断s中是否存在t中的字符
                total--;
            }

            // 如果total == 0, 意味着在j至i这段substring中，包含全部t的字符
            while (total == 0) {
                if (i - j + 1 < min) {
                    min = i - j + 1;
                    from = j;
                }
                if (++count[s.charAt(j++)] > 0) {
                    total++;
                }
            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(from, from + min);
    }

    @Test
    public void Test(){
        minWindow("","");

    }
}

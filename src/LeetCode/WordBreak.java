package LeetCode;

import java.util.List;

/**
 * Leetcode-139-Word Break-Medium
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.\
 *
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 *
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 *
 * Example 3:
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 *
 * 以Leetcode为例：
 *
 * | T |   |   |   |   |   |   |   |   |
 *   0   1   2   3   4   5   6   7   8
 *
 * i = 1
 * j = o sub = l
 *
 * i = 2
 * j = 0 sub = le
 * j = 1 sub = e
 *
 * i = 3
 * j = 0 sub = lee
 * j = 1 sub = ee
 * j = 2 sub = e
 *
 * i = 4
 * j = 0 sub = leet && T[0] and then break, no need to check for rest
 *
 * | T |   |   |   | T |   |   |   |   |
 *   0   1   2   3   4   5   6   7   8
 *
 * i = 5
 * j = 0 sub = leetc
 * j = 1 sub = eetc
 * j = 2 sub = etc
 * j = 3 sub = tc
 * j = 4 sub = c
 *
 * i = 6
 * j = 0 sub = leetco
 * j = 1 sub = eetco
 * j = 2 sub = etco
 * j = 3 sub = tco
 * j = 4 sub = co
 * j = 5 sub = o
 *
 * i = 7
 * j = 0 sub = leetcod
 * j = 1 sub = eetcod
 * j = 2 sub = etcod
 * j = 3 sub = tcod
 * j = 4 sub = cod
 * j = 5 sub = od
 * j = 6 sub = d
 *
 * i = 8
 * j = 0 sub = leetcode
 * j = 1 sub = eetcode
 * j = 2 sub = etcode
 * j = 3 sub = tcode
 * j = 4 sub = code && T[4] and then break
 *
 * | T |   |   |   | T |   |   |   | T |
 *   0   1   2   3   4   5   6   7   8
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    // 如果s的substring在wordDict中存在
                    // 则将dp[i]赋为true，直接结束循环，从下一个i接着开始比较
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}

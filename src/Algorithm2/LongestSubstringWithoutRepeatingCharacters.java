package Algorithm2;

import java.util.HashMap;

/**
 * Leetcode-3-Longest Substring Without Repeating Characters-Medium
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() < 1) {
            return 0;
        }

        int result = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        // 表示最长子序列的起始index
        int j = 0;
        for (int i = 0; i < s.length(); i++) {

            // 如果hashmap已经存在这个数字
            // 需要重新确定子序列的起始index
            if (hashMap.containsKey(s.charAt(i))) {

                // 此时hashMap.get(s.charAt(i))获得的index是之前已经保存的那个字符的index
                // 并不是新加入字符的index
                j = Math.max(j, hashMap.get(s.charAt(i)) + 1);
            }

            // 如果是新的字符，则会保存index
            // 如果是重复的字符，则会更新之前保存的index
            hashMap.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }

        return result;
    }
}

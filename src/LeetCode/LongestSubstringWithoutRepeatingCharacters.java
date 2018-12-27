package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * Leetcode-3-Longest Substring Without Repeating Characters
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
 *
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

        // j 代表最长自字符串的起始index
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {
                j = Math.max(j, hashMap.get(s.charAt(i)) + 1);
            }

            hashMap.put(s.charAt(i), i);
            result = Math.max(result, i - j + 1);
        }

        return result;
    }

    @Test
    public void Test(){
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));

    }
}

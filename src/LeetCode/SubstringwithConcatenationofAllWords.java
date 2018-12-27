package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode-30-Substring with Concatenation of All Words
 *
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s
 * that is a concatenation of each word in words exactly once and without any intervening characters.
 *
 * Example 1:
 * Input:
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * Output: [0,9]
 *
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 *
 * Example 2:
 * Input:
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * Output: []
 */
public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null) {
            return result;
        }

        int n = words.length;  // 单词个数
        int m = words[0].length();  //单词的长度（所有单词长度相同）

        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            // hashMap.getOrDefault(), 设置默认值0，如果这个单词不存在hashmap中，则在默认值上+1
            // 如果已经存在，则直接+1
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }

        // n*m是substring总的长度
        // 如果i > s.length()-n*m 则说明剩余的长度肯定是小于n*m
        // 就不需要再往后遍历
        for (int i = 0; i <= s.length() - n * m; i++) {
            HashMap<String, Integer> copy = new HashMap<>(hashMap);

            int k = n; // 单词个数
            int j = i;  // 起始index

            while (k > 0) {
                String str = s.substring(j, j + m);
                if (!copy.containsKey(str) || copy.get(str) < 1) {
                    // copy中不存在str，直接进行下一个循环
                    break;
                }

                // 如果存在str, 将str数量-1
                copy.put(str, copy.get(str) - 1);
                k--;  // 剩余单词个数-1
                j += m;
            }

            if (k == 0) {
                result.add(i);
            }
        }

        return result;
    }
}

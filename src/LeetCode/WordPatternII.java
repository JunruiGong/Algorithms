package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Leetcode-291-Word Pattern II-Hard
 *
 * Given a pattern and a string str, find if strfollows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 *
 * Example 1:
 * Input: pattern = "abab", str = "redblueredblue"
 * Output: true
 *
 * Example 2:
 * Input: pattern = pattern = "aaaa", str = "asdasdasdasd"
 * Output: true
 *
 * Example 3:
 * Input: pattern = "aabb", str = "xyzabcxzyabc"
 * Output: false
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 */
public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {

        if (str.length() < pattern.length()) {
            return false;
        }

        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        return isMatch(map, set, 0, 0, str, pattern);
    }

    private boolean isMatch(Map<Character, String> map, Set<String> set, int i, int j, String str, String pattern) {

        // i 表示str的index
        // j 表示pattern的index

        // str和pattern都遍历到最后则符合条件，返回true
        if (i == str.length() && j == pattern.length()) {
            return true;
        }

        // 只有一个遍历到最后，不符合，返回false
        if (i == str.length() || j == pattern.length()) {
            return false;
        }

        // 获得当前的character
        char c = pattern.charAt(j);

        // 如果map中已经保存
        // 则比较str中的substr是否与map中保存的str相同
        if (map.containsKey(c)) {
            String s = map.get(c);

            if (!str.startsWith(s, j)) {
                // 不匹配返回false
                return false;
            }

            // 如果匹配，继续进行比较
            isMatch(map, set, i + s.length(), j + 1, str, pattern);
        }

        // 如果pattern的字符不存在map中
        for (int k = i; k < str.length(); k++) {
            String p = str.substring(i, k + 1);

            if (set.contains(p)) {
                continue;
            }

            map.put(c, p);
            set.add(p);

            if (isMatch(map, set, k + 1, j + 1, str, pattern)) {
                return true;
            }

            // Backtracking
            map.remove(c);
            set.remove(p);
        }

        return false;
    }
}

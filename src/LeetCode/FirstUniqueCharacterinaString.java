package LeetCode;

/**
 * Leetcode-387-First Unique Character in a String
 *
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {

        if (s == null || s.length() < 1) {
            return -1;
        }

        int[] characCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            characCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (characCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}

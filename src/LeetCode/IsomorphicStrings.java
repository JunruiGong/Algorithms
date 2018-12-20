package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * Leetcode-205-Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {

        if (s == null || t == null) {
            return true;
        }

        HashMap<Character, Character> hashMap = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);

            if (hashMap.containsKey(a)) {
                if (!hashMap.get(a).equals(b)) {
                    return false;
                }
            } else {
                if (!hashMap.containsValue(b)){
                    hashMap.put(a, b);
                }else {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void Test(){

        String s = "ab";
        String t = "aa";

        isIsomorphic(s,t);
    }
}

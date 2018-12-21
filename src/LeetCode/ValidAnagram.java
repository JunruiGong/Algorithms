package LeetCode;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Leetcode-242-Valid Anagram
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class ValidAnagram {

    // 自己写的
    public boolean isAnagram(String s, String t) {

        if (s == null && t == null) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (!hashMap.containsKey(a[i])) {
                hashMap.put(a[i], 1);
            } else {
                int count = hashMap.get(a[i]) + 1;
                if (count == 0) {
                    hashMap.remove(a[i]);
                } else {
                    hashMap.replace(a[i], count);
                }
            }

            if (!hashMap.containsKey(b[i])) {
                hashMap.put(b[i], -1);
            } else {

                int count = hashMap.get(b[i]) - 1;

                if (count == 0) {
                    hashMap.remove(b[i]);
                } else {
                    hashMap.replace(b[i], count);
                }
            }
        }

        return hashMap.isEmpty();
    }


    // 更快的方法
    public boolean isAnagram2(String s, String t) {

        if (s == null && t == null) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        char[] a = s.toCharArray();
        char[] b = t.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }



    @Test
    public void Test() {

        System.out.println(isAnagram2("anagram", "nagarbm"));

    }

}

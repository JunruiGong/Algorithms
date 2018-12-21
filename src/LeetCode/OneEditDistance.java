package LeetCode;

import org.junit.Test;

/**
 * Leetcode-161-One Edit Distance
 *
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 *  Example 1:
 *  Input: s = "abc", t = "ab"
 *  Output: true
 *
 *  Example 2:
 *  Input: s = "abcd", t = "abef"
 *  Output: false
 */
public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {

        if (s == null && t == null) {
            return true;
        }

        if (s == null || t == null) {
            return false;
        }

        if (Math.abs(s.length() - t.length()) > 1) {
            return false;
        } else if (s.length() - t.length() == 1) {
            return isOneRemoveDistance(s, t);
        } else if (s.length() - t.length() == -1) {
            return isOneRemoveDistance(t, s);
        } else if (s.length() == t.length()) {
            return isOneChangeDistance(s, t);
        }

        return false;

    }

    private boolean isOneRemoveDistance(String s, String t) {
        boolean flag = false;
        for (int i = 0, j = 0; i < s.length()-1; i++, j++) {

            if (s.charAt(i) != t.charAt(j)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                    j--;
                }
            }
        }

        return flag;

    }

    private boolean isOneChangeDistance(String s, String t) {
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != t.charAt(i)) {
                if (flag) {
                    return false;
                } else {
                    flag = true;
                }
            }
        }

        return flag;
    }

    @Test
    public void Test(){
        String s = "abcd";
        String t = "abrf";
        System.out.println(isOneEditDistance(s,t));

    }
}

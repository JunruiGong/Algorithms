package LeetCode;

/**
 * Leetcode-214-Shortest Palindrome-Hard
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 *
 * Example 2:
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 * KMP算法：
 * https://blog.csdn.net/v_july_v/article/details/7041827
 *
 * Explanation:
 * https://leetcode.com/problems/shortest-palindrome/discuss/60113/Clean-KMP-solution-with-super-detailed-explanation
 *
 * */
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }

        String r = new StringBuilder(s).reverse().toString();

        String temp = s + "#" + r;
        int[] next = new int[temp.length()];

        for (int i = 1; i < temp.length(); i++) {
            int j = next[i - 1];
            while (j > 0 && temp.charAt(i) != temp.charAt(j)) {
                j = next[j - 1];
            }

            j += (temp.charAt(i) == temp.charAt(j) ? 1 : 0);
            next[i] = j;
        }

        return r.substring(0, s.length() - next[temp.length() - 1]) + s;
    }
}

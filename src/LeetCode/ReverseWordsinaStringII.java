package LeetCode;

/**
 * Leetcode-186-Reverse Words in a String II
 *
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinaStringII {
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0;
        char[] c = s.toCharArray();

        // 先将所有字符都翻转一遍
        reverse(c, 0, c.length - 1);
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                // 遇到空格再翻转一遍
                reverse(c, start, i - 1);
                start = i + 1;
            }
        }

        return new String(c);

    }

    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }
    }
}

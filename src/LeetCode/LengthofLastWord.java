package LeetCode;

/**
 * Leetcode-58-Length of Last Word
 *
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 *
 * Input: "Hello World"
 * Output: 5
 */
public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
        // 更简便的方法
        // return s.trim().length()-s.trim().lastIndexOf(" ")-1;

        if (s == null || s.length() < 1) {
            return 0;
        }
        int flag = 0;
        s = s.trim();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                flag++;
            } else {
                break;
            }
        }

        return flag;
    }
}

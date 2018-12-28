package LeetCode;

import org.junit.Test;

/**
 * Leetcode-125-Valid Palindrome
 *
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return true;
        }

        int head = 0;
        int tail = s.length() - 1;

        while (head <= tail) {
            if (!Character.isLetterOrDigit(s.charAt(head))) {
                head++;
            } else if (!Character.isLetterOrDigit(s.charAt(tail))) {
                tail--;
            } else if (Character.toLowerCase(s.charAt(head)) == Character.toLowerCase(s.charAt(tail))) {
                head++;
                tail--;
            } else {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}

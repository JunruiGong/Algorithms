package LeetCode;

import org.junit.Test;

import java.util.HashSet;

/**
 * Leetcode-345-Reverse Vowels of a String
 *
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Input: "hello"
 * Output: "holle"
 *
 * Example 2:
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {
    public String reverseVowels(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        HashSet<Character> hashset = new HashSet<>();
        hashset.add('a');
        hashset.add('e');
        hashset.add('i');
        hashset.add('o');
        hashset.add('u');
        hashset.add('A');
        hashset.add('E');
        hashset.add('I');
        hashset.add('O');
        hashset.add('U');


        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;

        while (left < right) {
            while (left<right && !hashset.contains(c[left])){
                left++;
            }

            while (left<right && !hashset.contains(c[right])){
                right--;
            }
            if (hashset.contains(c[left]) && hashset.contains(c[right]) && c[left] != c[right]) {
                swap(c, left, right);
            }
            left++;
            right--;
        }

        return new String(c);
    }

    private void swap(char[] c, int i, int j) {
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

    }

    @Test
    public void Test() {
        String s = "leetcode";
        reverseVowels(s);
    }
}

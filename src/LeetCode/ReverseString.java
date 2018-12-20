package LeetCode;

import org.junit.Test;

/**
 * Leetcode-344-Reverse String
 *
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example 1:
 * Input: "hello"
 * Output: "olleh"
 *
 * Example 2:
 * Input: "A man, a plan, a canal: Panama"
 * Output: "amanaP :lanac a ,nalp a ,nam A"
 */
public class ReverseString {
    public String reverseString(String s) {

        int left = 0;
        int right = s.length()-1;
        char[] charArray = s.toCharArray();

        while (left<right){
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }

        return new String(charArray);
    }

    @Test
    public void Test(){
        String s ="hello";
        reverseString(s);

    }
}

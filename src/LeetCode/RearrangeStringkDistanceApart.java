package LeetCode;

/**
 * Leetcode-358-Rearrange String k Distance Apart
 *
 * Given a non-empty string str and an integer k,
 * rearrange the string such that the same characters are at least distance k from each other.
 *
 * All input strings are given in lowercase letters.
 * If it is not possible to rearrange the string, return an empty string "".
 *
 * Example 1:
 * str = "aabbcc", k = 3
 *
 * Result: "abcabc"
 * The same letters are at least distance 3 from each other.
 *
 * Example 2:
 * str = "aaabc", k = 3
 *
 * Answer: ""
 * It is not possible to rearrange the string.
 *
 * Example 3:
 * str = "aaadbbcc", k = 2
 *
 * Answer: "abacabcd"
 *
 * Another possible answer is: "abcabcda"
 *
 * The same letters are at least distance 2 from each other.
 *
 * Credits:
 * Special thanks to @elmirap for adding this problem and creating all test cases.
 */
public class RearrangeStringkDistanceApart {
    public String rearrangeString(String s, int k) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int[] count = new int[26];
        int[] valid = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nextLetter = findNextLetter(count, valid, i);
            if (nextLetter == -1) {
                return "";
            }
            stringBuilder.append((char) ('a' + nextLetter));
            valid[nextLetter] = i + k;
            count[nextLetter]--;

        }

        return stringBuilder.toString();

    }

    private int findNextLetter(int[] count, int[] valid, int index) {

        int max = 0;
        int result = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > max && valid[i] <= index) {
                result = i;
                max = count[i];

            }
        }

        return result;
    }

}

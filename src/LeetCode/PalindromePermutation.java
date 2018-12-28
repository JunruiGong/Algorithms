package LeetCode;

/**
 * Leetcode-266-Palindrome Permutation
 *
 * Given a string, determine if a permutation of the string could form a palindrome.
 *
 * For example,
 * "code" -> False, "aab" -> True, "carerac" -> True.
 *
 * Hint:
 *
 * Consider the palindromes of odd vs even length. What difference do you notice?
 * Count the frequency of each character.
 * If each character occurs even number of times, then it must be a palindrome.
 * How about character which occurs odd number of times?
 */
public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int[] count = new int[256];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int even = 0;
        int odd = 0;

        // 统计各个字符的个数
        for (int aCount : count) {
            if (aCount % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        // 根据题意，如果s的长度是偶数，则所有的字符个数必须是偶数
        // 如果s的长度是奇数，则只有一个字符的个数是奇数，其他的都为偶数
        if (s.length() % 2 == 0) {
            return odd == 0;
        } else {
            return odd == 1;
        }
    }
}

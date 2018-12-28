package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode-267-Palindrome Permutation II
 *
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 *
 * For example:
 *
 * Given s = "aabb", return ["abba", "baab"].
 *
 * Given s = "abc", return [].
 *
 * Hint:
 *
 * If a palindromic permutation exists, we just need to generate the first half of the string.
 * To generate all distinct permutations of a (half of) string,
 * use a similar approach from: Permutations II or Next Permutation.
 */
public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {

        List<String> result = new ArrayList<>();

        if (s == null || s.length() < 1) {
            return result;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }

        int oddCount = 0;  // 字符个数是奇数的数量
        int oddChar = 'a';

        for (char c : hashMap.keySet()) {
            if (hashMap.get(c) % 2 != 0) {
                oddCount++;
                oddChar = c;
            }
        }

        if (oddCount >= 2) {
            // 如果字符个数是奇数的数量大于2，
            // 则说明该字符串无法组成回文，直接返回result
            return result;
        } else if (oddCount == 1) {
            // 将oddChar放中间，分别向两边扩散
            searchPath(hashMap, oddChar + "", s.length(), result);

        } else {
            // 没有奇数，直接开始扩散
            searchPath(hashMap, "", s.length(), result);
        }

        return result;
    }

    private void searchPath(HashMap<Character, Integer> hashMap, String current, int target, List<String> result) {
        // target 表示需要组成的字符串长度

        String newCurrent = current;
        if (newCurrent.length() == target) {
            // 如果相等，则说明一组排列已经结束
            result.add(newCurrent);
            return;
        }

        for (char c : hashMap.keySet()) {
            if (hashMap.get(c) >= 2) {
                newCurrent = c + current + c;  // 将相同的字符加在两边
                hashMap.put(c, hashMap.get(c) - 2);
                searchPath(hashMap, newCurrent, target, result);
                hashMap.put(c, hashMap.get(c) + 2);

            }
        }
    }
}

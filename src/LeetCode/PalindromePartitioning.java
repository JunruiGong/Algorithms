package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-131-Palindrome Partitioning-Medium
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return all possible palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * */
public class PalindromePartitioning {

    List<List<String>> resultList;
    List<String> currList ;

    public List<List<String>> partition(String s) {

        resultList = new ArrayList<>();
        currList = new ArrayList<>();
        if (s == null || s.length() < 1) {
            return resultList;
        }

        helper(s, 0);
        return resultList;
    }

    private void helper(String s, int l) {

        if (currList.size() > 0 && l >= s.length()) {
            // 说明当前分割情况下的所有子字符串已经判断完毕，可以将其放入resultList中
            List<String> copy = new ArrayList<>(currList);
            resultList.add(copy);
        }

        for (int i = l; i < s.length(); i++) {
            if (isPalindrome(s, l, i)) {
                if (i == l) {
                    currList.add(String.valueOf(s.charAt(i)));
                } else {
                    currList.add(s.substring(l, i + 1));
                }

                helper(s, i+1);
                currList.remove(currList.size() - 1);
            }
        }
    }


    // 判断substring是不是回文字符串
    private boolean isPalindrome(String s, int start, int end) {

        if (start == end) {
            return true;
        }
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }

        return true;
    }
}

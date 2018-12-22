package LeetCode;


import org.junit.Test;

import java.util.Stack;

/**
 * Leetcode-316-Remove Duplicate Letters
 *
 * Given a string which contains only lowercase letters,
 * remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {

        if (s == null || s.length() < 1) {
            return "";
        }

        char[] ch = s.toCharArray();
        int[] count = new int[26];

        // 记录每个字母是否已经出现过
        boolean[] visited = new boolean[26];

        // 统计每个字母出现的次数
        for (char c : ch) {
            count[c - 'a']++;
        }

        Stack<Character> stack = new Stack<>();

        for (char c : ch) {
            count[c - 'a']--;

            // 如果已经出现过该字母，则直接进行下一次循环
            if (visited[c - 'a']) {
                continue;
            }

            // 如果该字母小于栈顶字母且栈顶字母还有剩余，则可以将栈顶字母取出
            // 这样做的目的是将栈内的字母尽可能得按照字母表顺序排列
            // 如果此时栈顶字母已经没有剩余（count[stack.peek()-'a'] == 0）
            // 则意味着不再需要取出栈顶字母，因为题目要求不能改变原字符串的顺序
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] != 0) {
                visited[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            visited[c - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            // 倒叙组成stringBuilder
            stringBuilder.insert(0, stack.pop());
        }

        return stringBuilder.toString();
    }

    @Test
    public void Test() {
        String s = "bcabc";
        System.out.println(removeDuplicateLetters(s));
    }
}

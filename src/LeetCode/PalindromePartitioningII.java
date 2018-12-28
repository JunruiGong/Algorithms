package LeetCode;

/**
 * Leetcode-132-Palindrome Partitioning II-Hard
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 * Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example:
 *
 * Input: "aab"
 * Output: 1
 * Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
 *
 */
public class PalindromePartitioningII {
    public int minCut(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }

        char[] c = s.toCharArray();

        // 保存所有符合条件的cut次数，最后一位储存的次数是最小的
        int[] cut = new int[s.length()];

        boolean[][] pal = new boolean[s.length()][s.length()];

        // i: substring的结尾index
        // j: substring的开头index
        for (int i = 0; i < s.length(); i++) {
            int min = i;
            for (int j = 0; j <= i; j++) {

                // 判断当前substring是否是回文
                if (c[i] == c[j] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
                    pal[j][i] = true;
                    min = j == 0 ? 0 : Math.min(min, cut[j - 1] + 1);
                }

            }

            cut[i] = min;
        }

        return cut[s.length() - 1];
    }
}

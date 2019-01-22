package LeetCode;

/**
 * Leetcode-72-Edit Distance-Hard
 *
 * Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
 *
 * You have the following 3 operations permitted on a word:
 *
 * Insert a character
 * Delete a character
 * Replace a character
 *
 * Example 1:
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation:
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 *
 * Example 2:
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation:
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 *
 *
 * dp[i][j] 表示从字符串1的i位置转换到字符串2的j位置，所需要最少的步骤
 *
 * 1.字符串中的字符相等：dp[i][j]=dp[i-1][j-1]
 * 2.字符串中的字符不相等：
 *      insert: dp[i][j] = dp[i][j-1]+1
 *      replace:dp[i][j] = dp[i-1][j-1]+1
 *      delete:dp[i][j] = dp[i-1][j]+1
 *
 *
 *      a  b  c  d
 *   0  1  2  3  4
 * a 1  0  1  2  3
 * e 2  1  1  2  3
 * f 3  2  2  2  3
 *
 * 以(1,3)这个点为例：两个子字符串为a和abc，至少需要两次操作，所以在(1,3)处填2
 * 以(2,4)这个点为例：两个子字符串为ae和abcd，至少需要三次操作，所以在(2,4)处填3
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {

                // 两个字符串相等，直接复制前一个字符串的修改次数
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {

                    // 两个字符串不相等，找到三种情况中（插入，删除，替换）次数最少的一种
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1), dp[i - 1][j - 1] + 1);
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }
}

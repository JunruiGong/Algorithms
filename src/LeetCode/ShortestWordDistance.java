package LeetCode;

/**
 * Leetcode-243-Shortest Word Distance
 * <p>
 * Gives a list of words and two word1 and word2,
 * return the shortest distance between these two words in the list.
 * <p>
 * Example:
 * <p>
 * words = ["practice", "makes", "perfect", "coding", "makes"].
 * word1 = "coding", word2 = "practice", return 3.
 * word1 = "makes", word2 = "coding", return 1.
 */


public class ShortestWordDistance {

    // time O(n^2)
    public int shortestWordDistance1(String[] words, String word1, String word2) {

        int res = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        res = Math.min(res, Math.abs(i - j));
                    }
                }
            }
        }

        return res;
    }

    // time O(n)
    public int shortestWordDistance2(String[] words, String word1, String word2) {

        // 对于每个word1，我们需要找到离它最近的word2；
        // 对于每个word2，我们需要找到离它最近的word1。

        int index1 = -1;
        int index2 = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {

            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    minLen = Math.min(minLen, Math.abs(i - index2));
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    minLen = Math.min(minLen, Math.abs(i - index1));
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}

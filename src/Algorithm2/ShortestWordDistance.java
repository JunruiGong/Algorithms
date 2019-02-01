package Algorithm2;

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
    public int shortestWordDistance1(String[] words, String word1, String word2) {

        if (words == null || words.length < 1) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                for (int j = 0; j < words.length; j++) {
                    if (words[j].equals(word2)) {
                        result =   Math.min(result, Math.abs( i - j));
                    }
                }
            }
        }
        return result;
    }

    public int shortestWordDistance2(String[] words, String word1, String word2) {

        if (words == null || words.length < 1) {
            return 0;
        }

        int index1 = -1;
        int index2 = -1;
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    minLen = Math.min(minLen, Math.abs(index1 - index2));
                }
            }

            if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    minLen = Math.min(minLen, Math.abs(index1 - index2));
                }
            }
        }

        return minLen != Integer.MAX_VALUE ? -1 : minLen;
    }
}

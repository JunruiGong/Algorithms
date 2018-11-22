package LeetCode;

/**
 * Leetcode-245-Shortest Word Distance III
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * <p>
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * <p>
 * word1 and word2 may be the same and they represent two individual words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 */
public class ShortestWordDistanceIII {

    public int shortestWordDistanceIII(String[] words, String word1, String word2) {
        int a = -1;
        int b = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                a = i;
            } else if (words[i].equals(word2)) {
                b = i;
            }

            if (a != -1 && b != -1 && a != b) {

                min = Math.min(min, Math.abs(a - b));
            }

            if (word1.equals(word2)) {
                a = b;
            }
        }

        return min;


    }
}

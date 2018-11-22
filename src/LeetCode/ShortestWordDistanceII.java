package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Leetcode-244-Shortest Word Distance II
 * This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words
 * and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?
 * <p>
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 * <p>
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * <p>
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistanceII {

    Map<String, List<Integer>> map;

    // 将words中的单词存放到map中，这样就不要每次调用时都遍历一遍words。

    public ShortestWordDistanceII(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);

            } else {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {

        if (word1 == null | word2 == null) {
            return Integer.MAX_VALUE;
        }

        List<Integer> word1List = map.get(word1);
        List<Integer> word2List = map.get(word2);

        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        while (i < word1List.size() && j < word2List.size()) {
            min = Math.min(min, Math.abs(word1List.get(i) - word2List.get(j)));
            if (word1List.get(i) < word2List.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return min;
    }

}

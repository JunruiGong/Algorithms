package Algorithm2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    HashMap<String, List<Integer>> map = new HashMap<>();

    public ShortestWordDistanceII(String[] words) {

        for (int i=0;i<words.length;i++) {
            if (map.containsKey(words[i])) {
                map.get(words[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        list1 = map.get(word1);
        list2 = map.get(word2);


        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;

        while (i < list1.size() && j < list2.size()) {
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));

            if (list1.get(i) < list2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return min;
    }
}
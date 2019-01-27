package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Leetcode-127-Word Ladder-Medium
 *
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 *
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 * Example 1:
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Example 2:
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 *
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // BFS
        // hashset中存放wordlist的单词
        // 如果使用过wordlist中的单词，则需要将该单词移除
        HashSet<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        Queue<String> queue = new LinkedList<>();
        int level = 1;  // 表示层数，（进行到第几个单词？）
        int curNum = 1;
        int nextNum = 0;

        queue.offer(beginWord);
        while (!queue.isEmpty()) {

            // 从头取出queue中的单词
            String word = queue.poll();
            curNum--;

            // 将这个单词中的每个字母都替换一遍
            for (int i = 0; i < word.length(); i++) {
                char[] wordUnit = word.toCharArray();
                for (char j = 'a'; j <= 'z'; j++) {

                    // 将word中的第i位字母替换成j
                    wordUnit[i] = j;

                    // 形成新的单词
                    String newWord = new String(wordUnit);

                    // 新的单词在wordlist中存在
                    if (set.contains(newWord)) {

                        // 新的单词已经是endword，则完成转换，返回结果
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // 还没有到endword
                        nextNum++;
                        queue.offer(newWord);
                        set.remove(newWord);
                    }
                }
            }

            if (curNum == 0) {
                curNum = nextNum;
                nextNum = 0;
                level++;
            }
        }
        return 0;
    }
}

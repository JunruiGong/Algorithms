package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-68-Text Justification
 *
 * Given an array of words and a width maxWidth,
 * format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach;
 * that is, pack as many words as you can in each line.
 * Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible.
 * If the number of spaces on a line do not divide evenly between words,
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * Example 1:
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * Example 2:
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 *              because the last line must be left-justified instead of fully-justified.
 *              Note that the second line is also left-justified becase it contains only one word.
 *
 * Example 3:
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int index = 0;
        while (index < words.length) {
            int count = words[index].length();  // 记录单词的长度
            int last = index + 1;  // 用于记录每一行最后一个单词的index

            while (last < words.length) {
                if (words[last].length() + count + 1 > maxWidth) {
                    // 如果长度超过maxWidth就退出循环，此时找到了每一行最后一个单词的index。
                    break;
                }

                count += 1 + words[last].length();
                last++;
            }

            // 确定每一行的单词后，开始组合单词
            StringBuilder stringBuilder = new StringBuilder();

            stringBuilder.append(words[index]); //每一行的第一个单词

            // diff代表每一行空格的个数，
            // 如："Science  is  what we" 有三个空格；
            // "understand      well" 有一个空格
            int diff = last - index - 1;

            if (last == words.length || diff == 0) {  // 最后一行或者这一行只有一个单词的情况
                for (int i = index + 1; i < last; i++) {
                    stringBuilder.append(" ");
                    stringBuilder.append(words[i]);
                }

                for (int i = stringBuilder.length(); i < maxWidth; i++) {  // 在最后填充空格
                    stringBuilder.append(" ");
                }
            } else {
                int spaces = (maxWidth - count) / diff;  // 两个单词之间需要的空格数量

                // 当出现空格数量不一致的情况，如：
                // "Science  is  what we"   空格数量分别为2 2 1，此时需要r进行补充
                int r = (maxWidth - count) % diff;

                for (int i = index + 1; i < last; i++) {
                    for (int k = spaces; k > 0; k--) {
                        stringBuilder.append(" ");
                    }

                    if (r > 0) {
                        stringBuilder.append(" ");
                        r--;
                    }

                    stringBuilder.append(" ");
                    stringBuilder.append(words[i]);
                }
            }

            result.add(stringBuilder.toString());
            index = last;
        }

        return result;
    }
}

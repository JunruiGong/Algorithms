package LeetCode;

import org.junit.Test;

/**
 * Leetcode-318-Maximum Product of Word Lengths-Medium
 *
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j])
 * where the two words do not share common letters.
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 *
 * Example 1:
 *
 * Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * Output: 16
 * Explanation: The two words can be "abcw", "xtfn".
 * Example 2:
 *
 * Input: ["a","ab","abc","d","cd","bcd","abcd"]
 * Output: 4
 * Explanation: The two words can be "ab", "cd".
 * Example 3:
 *
 * Input: ["a","aa","aaa","aaaa"]
 * Output: 0
 * Explanation: No such pair of words.
 */
public class MaximumProductofWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }

        int result = 0;
        int[] value = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String temp = words[i];
            value[i] = 0;

            // 将每个字母出现的位置表示出来
            for (int j = 0; j < temp.length(); j++) {
                value[i] |= 1 << (temp.charAt(j) - 'a');
                // 组成一个26位二进制数
                // 从右往左，分别代表a->z
                // 哪个字母出现了，就在相应额位上置为1
                // 其余部分为0
            }

            //System.out.println(temp+"->"+value[i]+ "->"+Integer.toBinaryString(value[i]) );

            // abcw->4194311->10000000000000000000111
            // baz->33554435->10000000000000000000000011
            // foo->16416->100000000100000
            // bar->131075->100000000000000011
            // xtfn->8921120->100010000010000000100000
            // abcdef->63->111111
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((value[i] & value[j]) == 0) {// 与之后为0，说明没有一个字母相同
                    result = Math.max(result, words[i].length() * words[j].length());
                }
            }
        }
        return result;
    }

    @Test
    public void test(){
        String[] words={"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(maxProduct(words));

    }
}
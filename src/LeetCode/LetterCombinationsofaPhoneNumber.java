package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode-17-Letter Combinations of a Phone Number-Medium
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *      1   2   3
 *          abc def
 *      4   5   6
 *      ghi jkl mno
 *      7   8   9
 *     pqrs tuv wxyz
 *
 * Example:
 *
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 *
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 * 参考：Leetcode-78
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits==null||digits.length()<1){
            return result;
        }

        Map<Character, String> dict = constructWordDict();
        StringBuilder sb = new StringBuilder();
        help(digits, dict, 0, sb, result);
        return result;
    }

    private void help(String digits, Map<Character, String> dict, int index, StringBuilder sb, List<String> result) {
        if (index == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char ch = digits.charAt(index);
        String values = dict.get(ch);
        for (char c : values.toCharArray()) {
            sb.append(c);
            help(digits, dict, index + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

    private Map<Character, String> constructWordDict() {
        Map<Character, String> wordDict = new HashMap<>();

        wordDict.put('0', "");
        wordDict.put('1', "");
        wordDict.put('2', "abc");
        wordDict.put('3', "def");
        wordDict.put('4', "ghi");
        wordDict.put('5', "jkl");
        wordDict.put('6', "mno");
        wordDict.put('7', "pqrs");
        wordDict.put('8', "tuv");
        wordDict.put('9', "wxyz");
        return wordDict;
    }
}

package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode-249-Group Shifted Strings
 *
 * Given a string, we can "shift" each of its letter to its successive letter,
 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
 *
 * "abc" -> "bcd" -> ... -> "xyz"
 *
 * Given a list of strings which contains only lowercase alphabets,
 * group all strings that belong to the same shifting sequence.
 *
 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"],
 * Return:
 *
 * [
 *   ["abc","bcd","xyz"],
 *   ["az","ba"],
 *   ["acef"],
 *   ["a","z"]
 * ]
 *
 * Note: For the return value, each inner list's elements must follow the lexicographic order.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {

        // The basic idea is to shift all words back into the form starting with 'a'.
        // (all digits must shift the same distance).
        // If the two words share the same shifted word,
        // it means they actually come from the same shift group.

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {

            char[] ch = strings[i].toCharArray();
            if (ch.length > 0) {
                int adjust = ch[i] - 'a';
                for (int j = 0; j < ch.length; j++) {
                    // 计算所有的字母对'a'的偏移量，
                    // 如果两个字符川的偏移量相同，则可以认为这两个字符串在同一组中。
                    ch[j] = (char) ((ch[j] - 'a' - adjust + 26) % 26 + 'a');
                }
            }

            String key = new String(ch);
            if (hashMap.containsKey(key)) {
                List<String> list = hashMap.get(key);
                list.add(strings[i]);

            } else {
                List<String> list = new ArrayList<>();
                list.add(strings[i]);
                hashMap.put(key, list);
            }
        }

        return new ArrayList<>(hashMap.values());
    }
}

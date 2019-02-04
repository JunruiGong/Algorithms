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

        for (String string : strings) {

            char[] ch = string.toCharArray();
            if (ch.length > 0) {
                int diff = ch[0] - 'a';
                for (int j = 0; j < ch.length; j++) {
                    // 计算所有的字母对'a'的偏移量，
                    // 如果两个字符串的偏移量相同，则可以认为这两个字符串在同一组中。

                    // 字符串的每个字母和首字符的相对距离都是相等的，
                    // 比如abc和efg互为偏移，对于abc来说，b和a的距离是1，c和a的距离是2，
                    // 对于efg来说，f和e的距离是1，g和e的距离是2。
                    // az和yx，z和a的距离是25，x和y的距离也是25(直接相减是-1，这就是要加26然后取余的原因)，
                    // 那么这样的话，所有互为偏移的字符串都有个unique的距离差

                    if (ch[j] - diff >= 'a') {
                        ch[j] = (char) (ch[j] - diff);
                    } else {
                        ch[j] = (char) (ch[j] - diff + 26);
                    }
                }
            }

            String key = new String(ch);
            if (hashMap.containsKey(key)) {
                List<String> list = hashMap.get(key);
                list.add(string);

            } else {
                List<String> list = new ArrayList<>();
                list.add(string);
                hashMap.put(key, list);
            }
        }

        return new ArrayList<>(hashMap.values());
    }
}

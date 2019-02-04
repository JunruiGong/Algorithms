package Algorithm2;

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

        List<List<String>> result = new ArrayList<>();

        if (strings == null || strings.length < 1) {
            return result;
        }

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String string : strings) {
            char[] c = string.toCharArray();

            if (c.length > 0) {
                int diff = c[0] - 'a';

                for (int j = 0; j < c.length; j++) {
                    if (c[j] - diff > 'a') {
                        c[j] = (char) (c[j] - diff);
                    } else {
                        c[j] = (char) (c[j] - diff + 26);
                    }
                }
            }

            String temp = new String(c);

            if (hashMap.containsKey(temp)) {
                hashMap.get(temp).add(string);
            } else {
                List<String> list = new ArrayList<>();
                list.add(temp);
                result.add(list);
                hashMap.put(temp, list);
            }
        }
        return result;
    }
}

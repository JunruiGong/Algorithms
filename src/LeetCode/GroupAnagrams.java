package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Leetcode-49-Group Anagrams
 *
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {


    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> lists = new ArrayList<>();

        if (strs == null || strs.length < 1) {
            return lists;
        }

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String str = new String(c);

            if (hashMap.containsKey(str)) {
                // 从lists中取出list并添加新的字符串
                List<String> list = lists.get(hashMap.get(str));  // 通过hashmap中存入的size，相当于lists中的index，可以通过index找到对应的list
                list.add(strs[i]);

            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);  // list放sort前的字符串

                //hashmap放sort之后的字符串
                hashMap.put(str, lists.size());  // 当在hashmap中新存入一个string，lists中的size都会变化，知道这个size就能知道是具体哪个list
                lists.add(list);
            }
        }

        return lists;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {

        HashMap<String, List<String>> hashMap = new HashMap<>();

        for (String str : strs) {
            int[] count = new int[26];
            for (Character ch : str.toCharArray()) {
                count[ch - 'a']++;
            }

            String s = "";

            for (int i = 0; i < count.length; i++) {
                if (count[i] != 0) {

                    // 以"eat"为例，处理之后的s="1a1e1t"，根据s来判断字符串是否相等
                    s += String.valueOf(count[i]) + String.valueOf((char)(i + 'a'));
                }
            }

            if (hashMap.containsKey(s)) {
                List<String> list = hashMap.get(s);
                list.add(str);

            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(s, list);
            }
        }

        return new ArrayList<>(hashMap.values());

    }
}

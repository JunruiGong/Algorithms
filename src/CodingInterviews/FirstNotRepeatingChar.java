package CodingInterviews;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指offer-35-第一个只出现一次的字符位置
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写).
 */
public class FirstNotRepeatingChar {

    public int firstNotRepeatingChar(String str) {

        if (str.length() <= 0) {
            return -1;
        }

        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();


        // 在HashMap中存放字符和该字符位于数组中的位置
        // 如果该字符已经存在，则将它的index置为-1
        // 否则就存放该字符及它的index
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, -1);
            } else {
                hashMap.put(c, i);
            }
        }

        int index = Integer.MAX_VALUE;
        char result = '\0';

        // 遍历HashMap，比较HashMap中value（对应数组中的index）的大小
        // value必须满足>=0(表示只出现过一次)
        // 如果该value比上一次小，则说明该字符出现在更前面
        // 就记录该value，最后返回value。
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() >= 0 && entry.getValue() < index) {
                index = entry.getValue();
                result = entry.getKey();
            }
        }

        return index;
    }

    @Test
    public void Test() {

        String string = "zuDClOWjkPNhb";
        System.out.println(firstNotRepeatingChar(string));
    }
}

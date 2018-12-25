package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode-271-Encode and Decode Strings
 *
 * Design an algorithm to encode a list of strings to a string.
 * The encoded string is then sent over the network and is decoded back to the original list of strings.
 *
 * Machine 1 (sender) has the function:
 *
 * string encode(vector<string> strs) {
 *   // ... your code
 *   return encoded_string;
 * }
 *
 *
 * Machine 2 (receiver) has the function:
 *
 * vector<string> decode(string s) {
 *   //... your code
 *   return strs;
 * }
 *
 *
 * So Machine 1 does:
 * string encoded_string = encode(strs);
 *
 * and Machine 2 does:
 * vector<string> strs2 = decode(encoded_string);
 *
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 *
 * Implement the encode and decode methods.
 *
 * Note:
 *
 * The string may contain any possible characters out of 256 valid ascii characters.
 * Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
public class EncodeandDecodeStrings {
    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            // 在每个字符串前添加该字符串的长度和"/"
            // "abcd" -> "4/abcd"
            sb.append(s.length()).append("/").append(s);
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < s.length()) {
            int slash = s.indexOf("/", i);  // 获得"/"的位置
            int size = Integer.parseInt(s.substring(i, slash));  //获得字符串的大小
            result.add(s.substring(slash + 1, slash + size + 1));  //截取字符串
            i = slash + size + 1;
        }

        return result;
    }
}

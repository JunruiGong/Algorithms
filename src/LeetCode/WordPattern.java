package LeetCode;


import org.junit.Test;

import java.util.HashMap;

/**
 * Leetcode-290-Word Pattern
 *
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 *
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 *
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 *
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 *
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {

        HashMap<Character, String> hashMap = new HashMap<>();

        char[] c = pattern.toCharArray();
        String[] strSplit = str.trim().split(" ");
        if (c.length != strSplit.length) {
            return false;
        }

        for (int i = 0; i < c.length; i++) {
            if (hashMap.containsKey(c[i])) {
                if (!hashMap.get(c[i]).equals(strSplit[i])) {
                    return false;
                }
            } else {
                if (!hashMap.containsValue(strSplit[i])) {
                    hashMap.put(c[i], strSplit[i]);
                } else {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean wordPattern2(String pattern, String str) {

        if(str==null||str.length()<1){
            return false;
        }

        int index =0;
        for(int i=0;i<pattern.length();i++){
            if(index<str.length() &&pattern.charAt(i)==str.charAt(index)){
                while(index<str.length()){
                    if(str.charAt(index++)==' '){
                        break;
                    }
                }
            }else{
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){

        String pattern ="abba";
        String str = "dog cat cat dog";
        wordPattern2(pattern,str);

    }
}

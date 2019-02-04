package LeetCode;

import org.junit.Test;

/**
 * Leetcode-151-Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s==null||s.length()<1){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] str = s.trim().split("\\s+");  // 正则表达式：“\\s+”第一个“\”是用来转义的，“\s+” 正则表达式表示至少出现一个空格。
        for (int i= str.length-1;i>=0;i--){
            sb.append(str[i]+" ");
        }

        return sb.toString().trim();
    }


    public String reverseWords2(String s) {
        if(s==null||s.length()<1){
            return s;
        }

        s = s.trim();

        String[] strSplit = s.split(" ");

        int index = strSplit.length-1;

        StringBuilder sb = new StringBuilder();

        while(index>=0){

            sb.append(strSplit[index]);
            if(index!=0){
                sb.append(" ");
            }
            index--;
        }

        return sb.toString();
    }


    @Test
    public void test(){

        String s ="   a   b ";

        System.out.println(reverseWords2(s));
    }

}

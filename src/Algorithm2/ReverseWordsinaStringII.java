package Algorithm2;

import java.util.Arrays;

/**
 * Leetcode-186-Reverse Words in a String II
 *
 * Given an input string, reverse the string word by word. A word is defined as a sequence of non-space characters.
 * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 */
public class ReverseWordsinaStringII {

    public String reverseWords(String s) {
        if(s==null||s.length()<1){
            return s;
        }

        char[] c = s.toCharArray();

        reverse(c,0,c.length-1);
        int start=0;
        for(int i=0;i<c.length;i++){
            if(c[i]==' '){
                reverse(c,start,i-1);
                start=i+1;
            }
        }
        return Arrays.toString(c);


    }

    private void reverse(char[] s, int i,int j){
        while (i<j){
            char temp = s[i];
            s[i] = s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
}

package CodingInterviews;

import org.junit.Test;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 剑指offer-28-字符串的排列
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 长度不超过9(可能有字符重复),字符只包括大小写字母。
 */

public class SortChar {
    public ArrayList<String> Permutation(String str) {

        ArrayList<String> res = new ArrayList<String>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] charArray = str.toCharArray();

        //输出按照输入字典顺序, TreeSet会自动将插入的数据进行升序排序。
        TreeSet<String> tempRes = new TreeSet<String>();
        PermutationCore(charArray, tempRes, 0);
        res.addAll(tempRes);
        return res;

    }

    private void PermutationCore(char[] charArray, TreeSet<String> tempSet, int loc) {

        if (charArray == null || charArray.length == 0 || loc > charArray.length) {
            return;
        }

        if (loc == charArray.length - 1) {
            //String.valueOf return the string type of argument.
            tempSet.add(String.valueOf(charArray));  //递归出口
        } else {
            for (int i = loc; i < charArray.length; i++) {

                //第一次时，是将第一个字符与自己交换。
                //之后会将第一个字符与所有的字符都会交换一遍，交换之后再进行全排列。
                //相当于每次先固定第一个字符，然后再对后面的字符进行全排列
                //如输入"abc"
                //排列的顺序是：
                //a,b,c; a,c,b; b,a,c; b,c,a......
                swap(charArray, i, loc);
                PermutationCore(charArray, tempSet, loc + 1);//交换之后
                swap(charArray, i, loc);
            }
        }
    }


    private void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }

    @Test
    public void Test() {

        String a = "abc";
        Permutation(a);

    }
}

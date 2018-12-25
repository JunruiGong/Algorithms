package LeetCode;

import org.junit.Test;

/**
 * Leetcode-246-Strobogrammatic Number
 *
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Example 1:
 *
 * Input:  "69"
 * Output: true
 * Example 2:
 *
 * Input:  "88"
 * Output: true
 * Example 3:
 *
 * Input:  "962"
 * Output: false
 */
public class StrobogrammaticNumber {
    public boolean isStrobogrammatic(String num) {

        char[] c=num.toCharArray();

        int i=0;
        int j =c.length-1;

        while (i<=j){
            if (c[i]=='0' && c[j]=='0' ||
                    c[i]=='1' && c[j]=='1'||
                    c[i]=='8' && c[j]=='8'||
                    c[i]=='6' && c[j]=='9'||
                    c[i]=='9' && c[j]=='6'){
                i++;
                j--;
            }else{
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){
        String num = "1169111";
        System.out.println(isStrobogrammatic(num));
    }

}

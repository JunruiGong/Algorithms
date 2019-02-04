package Algorithm2;

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

        char[] chars = num.toCharArray();
        int start=0;
        int end=chars.length-1;

        while(start<=end){
            if(chars[start]=='1' && chars[end]=='1'||
                    chars[start]=='8' && chars[end]=='8'||
                    chars[start]=='9' && chars[end]=='6'||
                    chars[start]=='6' && chars[end]=='9'){

                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}

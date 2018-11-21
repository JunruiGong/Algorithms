package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-47-把字符串转换成整数
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */

public class StrToInt {
    public int strToInt(String str) {
//        Integer.valueOf()


        if (str == null || str.length() < 1) {
            return 0;
        }

        boolean negative = false;
        int limit = Integer.MAX_VALUE;
        int digit = 0;

        char firstChar = str.charAt(0);

        if (!(firstChar >= '0' && firstChar <= '9')) {

            if (firstChar == '-') {
                negative = true;
                limit = Integer.MIN_VALUE;
            } else if (firstChar != '+') {
                return 0;
            }

            for (int i = 1; i < str.length(); i++) {

                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    digit = digit * 10 + str.charAt(i) - '0';
                } else {
                    return 0;
                }
            }
        } else {
            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    digit = digit * 10 + str.charAt(i) - '0';
                } else {
                    return 0;
                }
            }
        }


        if (negative) {
            return (int) -digit;
        } else {
            return (int) digit;
        }
    }


    @Test
    public void Test() {
        System.out.println(strToInt("123"));

    }
}

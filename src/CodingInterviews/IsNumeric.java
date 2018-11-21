package CodingInterviews;

/**
 * 剑指offer-54-表示数值的字符串
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */

public class IsNumeric {
    public boolean isNumeric(char[] str) {

        if (str == null || str.length < 1) {
            return false;
        }

        int index = 0;

        //第一位是否为"+"或"-"
        if (str[index] == '+' || str[index] == '-') {
            index++;
        }

        //已经到达字符串末尾，return false
        if (index >= str.length) {
            return false;
        }

        boolean numeric = false;
        index = scanDigit(str, index);

        //还未到最后末尾
        if (index < str.length) {

            //如果有小数点
            if (str[index] == '.') {
                index++;
                index = scanDigit(str, index);
                if (index >= str.length) {
                    return true;
                } else if (str[index] == 'e' || str[index] == 'E') {//是否存在科学计数法
                    numeric = isExponential(str, index);
                } else {
                    numeric = false;
                }
            } else if (str[index] == 'e' || str[index] == 'E') {//没有小数点的情况下判断是否存在科学计数法
                numeric = isExponential(str, index);
            } else {
                numeric = false;
            }
            return numeric;
        } else {
            return true;
        }
    }

    //扫描字符串的数字部分
    private int scanDigit(char[] str, int index) {
        while (index < str.length && str[index] >= '0' && str[index] <= '9') {
            index++;
        }

        return index;
    }

    //判断是否为科学计数法
    private boolean isExponential(char[] str, int index) {
        if (index >= str.length || (str[index] != 'e' && str[index] != 'E')) {
            return false;
        }

        index++;

        if (index >= str.length) {
            return false;
        }

        if (str[index] == '+' || str[index] == '-') {
            index++;
        }

        if (index >= str.length) {
            return false;
        }

        index = scanDigit(str, index);

        return index >= str.length;
    }
}

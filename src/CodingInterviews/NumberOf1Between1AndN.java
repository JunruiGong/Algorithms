package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-32-从1到n整数中1出现的次数
 * 输入一个整数 n 求从 1 到 n 这 n 个整数的十进制表示中 1 出现的次数。
 */
public class NumberOf1Between1AndN {

    public int numberOf1Between1AndN_Solution(int n) {

        if (n <= 0) {
            return 0;
        }

        String[] numbersString = String.valueOf(n).split("");

        int[] numbers = new int[numbersString.length];
        for (int i = 0; i < numbersString.length; i++) {
            numbers[i] = Integer.parseInt(numbersString[i]);
        }


        return numberOf1(numbers, 0);
    }


    private int numberOf1(int[] numbers, int currentIndex) {

        if (numbers.length == 0 || currentIndex >= numbers.length || currentIndex < 0) {
            return 0;
        }

        //待处理的第一个数字
        int first = numbers[currentIndex];

        //要处理的数字在第几位
        int length = numbers.length - currentIndex;

        //该数为0
        if (first == 0 && length == 1) {
            return 0;
        }

        //该数是个位数
        if (first > 0 && length == 1) {
            return 1;
        }


        //其余情况
        //计算第一位中出现1的次数
        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = powerBase10(length - 1);
        } else if (first == 1) {
            numFirstDigit = atoi(numbers, currentIndex + 1) + 1;
        }

        //除了第一位之外的数位中的1的数目，排列组合
        int numOtherDigit = first * (length - 1) * powerBase10(length - 2);


        int numRecursive = numberOf1(numbers, currentIndex + 1);

        return numFirstDigit + numOtherDigit + numRecursive;

    }


    //将数字数组转换成数值
    private int atoi(int[] numbers, int i) {
        int result = 0;
        for (int j = i; j < numbers.length; j++) {

            result = result * 10 + numbers[j];
        }

        return result;
    }


    private int powerBase10(int n) {
        int result = 1;
        for (int i = 0; i < n; i++) {
            result = result * 10;
        }

        return result;
    }

    @Test
    public void Test(){
        System.out.println(numberOf1Between1AndN_Solution(21345));
    }
}

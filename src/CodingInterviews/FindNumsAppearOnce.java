package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-40-数组中只出现一次的数字
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * num1,num2分别为长度为1的数组。传出参数
 * 将num1[0],num2[0]设置为返回结果
 */
public class FindNumsAppearOnce {
    public void findNumsAppearOnce(int[] array, int num1[], int num2[]) {

        // 采用异或的方式进行查找
        // 异或的规律：如果两个数字相同，则会返回0，有一位字节不相同，则该位为1

        num1[0] = 0;
        num2[0] = 0;

        if (array.length > 1) {
            int xor = 0;

            // 先将所有的数进行异或运算，因为已知数组中有两个不相同的数
            // 所以异或的结果肯定存在1
            for (int i : array) {
                xor ^= i;
            }

            // 从右往左，找到第一次出现1的位置（不清楚为什么？）
            // 经过测试，如果从左往右进行寻找，
            // 可能会出现两个不同的数字被分到同一个数组中（如：1，2，4，4）
            // 原因在于1，2在二进制中为（0 0 0 1）和（0 0 1 0）
            // 与4（0 1 0 0），他们在第三位字节上存在不同，
            // 而1，2之间第三位是相同的。所以还是得从右往左进行寻找
            int indexOf1 = findFirstBit1(xor);

            // 依次判断每个数在该位上字节是否为1
            // 根据这一条件，将数组重新分成两个子数组
            // 一个子数组全是1， 一个全是0
            // 这样，两个不相同的数就会分到两个子数组中
            // 最后再分别对两个子数组里面的数进行异或运算
            // 就能找到这两个数
            for (int i : array) {
                if (isBit1(i, indexOf1)) {

                    num1[0] ^= i;

                } else {
                    num2[0] ^= i;
                }

            }
        } else {
            num1 = null;
            num2 = null;
        }
    }

    // 找到第一次1出现的位置
    private int findFirstBit1(int num) {
        int index = 0;
        while ((num & 1) == 0 && index < 32) {
            num >>>= 1;
            index++;
        }

        return index;
    }

    private boolean isBit1(int num, int indexBit) {
        num >>>= indexBit;
        return (num & 1) == 1;
    }

    @Test
    public void Test() {
        int[] array = {2, 4, 3, 6, 3, 2, 5, 5};
        int num1[] = new int[1];
        int num2[] = new int[1];
        findNumsAppearOnce(array, num1, num2);

    }
}

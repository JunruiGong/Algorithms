package CodingInterviews;

import org.junit.Test;

/**
 * 剑指offer-34-丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    public int GetUglyNumber_Solution(int index) {

        if (index <= 0) {
            return 0;
        }

        int[] uglyNumbers = new int[index];
        uglyNumbers[0] = 1;

        int nextUglyIndex = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        while (nextUglyIndex < index) {

            // 我们不需要通过计算每个丑数*2，*3，*5的结果
            // 因为有些丑数*2，*3，*5的结果会比当前数组中最大的值小，或者比最大值大很多
            // 但我们只需要每次找到第一个大于当前数组中最大值的数
            // 因为数组是排好序的，所以肯定存在一个数T,在它之前的数*2的结果会比最大值小（不需要考虑）
            // 在它之后的数*2的结果会比最大值大。所以我们需要记录这个分界点的位置。
            // 就是代码中的p2，p3, p5。每次只需要比较这三个位置*2，*3，*5的结果就行。减少不必要的计算量。

            int min = min(uglyNumbers[p2] * 2, uglyNumbers[p3] * 3, uglyNumbers[p5] * 5);

            uglyNumbers[nextUglyIndex] = min;

            while (uglyNumbers[p2] * 2 <= uglyNumbers[nextUglyIndex]) {
                p2++;
            }
            while (uglyNumbers[p3] * 3 <= uglyNumbers[nextUglyIndex]) {
                p3++;
            }
            while (uglyNumbers[p5] * 5 <= uglyNumbers[nextUglyIndex]) {
                p5++;
            }

            nextUglyIndex++;
        }
        return uglyNumbers[nextUglyIndex - 1];
    }


    private int min(int n1, int n2, int n3) {
        int min = n1 < n2 ? n1 : n2;
        return min < n3 ? min : n3;
    }


    @Test
    public void Test() {
        System.out.println(GetUglyNumber_Solution(1600));


    }
}

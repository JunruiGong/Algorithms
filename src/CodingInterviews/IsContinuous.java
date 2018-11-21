package CodingInterviews;

import org.junit.Test;

import java.util.Arrays;

/**
 * 剑指offer-44-扑克牌顺子
 * LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....
 * LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */

public class IsContinuous {
    public boolean isContinuous(int[] numbers) {

        if (numbers.length == 0) {
            return false;
        }

        quickSort(numbers, 0, numbers.length-1);
        System.out.println(numbers);
        //Arrays.sort(numbers);

        int numberOfZero = 0;
        int numberOfGap = 0;
        for (int i : numbers) {
            if (i == 0) {
                numberOfZero++;
            }
        }

        int small = numberOfZero;
        int big = small + 1;

        while (big < numbers.length) {
            if (numbers[small] == numbers[big]) {
                return false;
            }

            numberOfGap = numberOfGap + (numbers[big] - numbers[small] - 1);

            small = big;
            big++;
        }


        return numberOfGap <= numberOfZero;

    }

    private void quickSort(int[] array, int start, int end) {

        if (start < end) {

            int pivot = partition(array, start, end);
            quickSort(array, start, pivot - 1);
            quickSort(array, pivot + 1, end);

        }
    }

    private int partition(int[] array, int start, int end) {
        int pivot = array[end];

        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, end);
        return i + 1;
    }

    private void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Test
    public void Test() {

        int[] numbers = {0, 2, 1, 3, 4};
        isContinuous(numbers);

    }
}

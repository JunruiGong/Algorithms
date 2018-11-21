package CodingInterviews;

import org.junit.Test;

import java.util.Comparator;

/**
 * 剑指offer-33-把数组排成最小的数
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    public String printMinNumber(int[] numbers) {

        if (numbers.length == 0) {
            return "";
        }

        MComparator comparator = new MComparator();

        String[] numbersStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbersStr[i] = String.valueOf(numbers[i]);

        }

        quickSort(numbersStr, 0, numbersStr.length - 1, comparator);

        StringBuilder stringBuilder = new StringBuilder();
        for (String str : numbersStr) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();

    }


    private void quickSort(String[] array, int start, int end, Comparator<String> comparator) {
        //虽然是采用快排，但是我们需要重新定义一下"大小"的含义
        //如果m与n组合，mn<nm，那么我们认为m<n，反之亦然
        //这样在全部排完序之后，将数组拼成一个字符串，这个字符串就是最小值。
        //所以对数字放在pivot左边还是右边，比较的是两者组合之后，新的数字的大小。

        if (start < end) {
            String pivot = array[start];
            int left = start;
            int right = end;

            while (start < end) {
                while (start < end && comparator.compare(array[end], pivot) >= 0) {
                    end--;
                }
                array[start] = array[end];

                while (start < end && comparator.compare(array[start], pivot) <= 0) {
                    start++;
                }
                array[end] = array[start];
            }

            array[start] = pivot;
            quickSort(array, left, start - 1, comparator);
            quickSort(array, start + 1, end, comparator);
        }
    }


    private class MComparator implements Comparator<String> {

        //o1 < o2 --> return -1
        //o1 = o2 --> return 0
        //o1 > o2 --> return 1

        @Override
        public int compare(String o1, String o2) {

            if (o1 == null || o2 == null) {
                throw new IllegalArgumentException("Arg should not be null.");
            }

            String s1 = o1 + o2;
            String s2 = o2 + o1;

            return s1.compareTo(s2);
        }
    }

    @Test
    public void Test() {
//        String[] data = {"3", "5", "1", "4", "2"};

//        int[] data = {3, 5, 1, 4, 2};
        int[] data = {3, 32, 321};
        printMinNumber(data);
    }
}

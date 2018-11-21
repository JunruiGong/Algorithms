package CodingInterviews;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer-41-和为S的两个数字
 * <p>
 * 输入一个递增排序的数组和一个数字 s，
 * 在数组中查找两个数，得它们的和正好是 s。
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 */

public class FindNumbersWithSum {


    // 参考Leetcode第一题
    public static List<Integer> findNumbersWithSum1(int[] data, int sum) {

        if (data.length < 2) {
            return null;
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for (int i : data) {
            arrayList.add(i);
        }

        List<Integer> list = new ArrayList<Integer>();

        for (int i : data) {
            int a = sum - i;
            if (arrayList.contains(a)) {
                if (list.contains(a) || list.contains(i)) {
                    continue;
                }
                list.add(a);
                list.add(i);
            }
        }

        return list;
    }


    // 从数组头和尾选择两个数，如果输入的数等于sum，我们就找到了
    // 如果和小于sum，头的数增加一
    // 如果大于sum，尾的数减少一
    public static List<Integer> findNumbersWithSum2(int[] data, int sum) {

        List<Integer> list = new ArrayList<Integer>();
        if (data.length < 2) {
            return list;
        }


        int start = 0;
        int end = data.length - 1;
        int least = Integer.MAX_VALUE;

        while (start < end) {
            if (sum == data[start] + data[end]) {
                if ((data[start] * data[end]) < least) {
                    list.clear();
                    list.add(data[start]);
                    list.add(data[end]);
                    least = data[start] * data[end];
                }
                end--;

            } else if (sum < data[start] + data[end]) {
                end--;
            } else {
                start++;
            }
        }

        return list;
    }

    @Test
    public void Test() {

//        int[] data = {1,2,3,4,5};
        int[] data = {1, 2, 4, 7, 11, 15};
        findNumbersWithSum2(data, 15);
    }
}

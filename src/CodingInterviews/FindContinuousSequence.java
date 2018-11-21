package CodingInterviews;

import org.junit.Test;

import java.util.ArrayList;

/**
 * 剑指offer-41-和为S的连续正数序列
 * <p>
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * <p>
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<ArrayList<Integer>>();

        if (sum < 3) {
            return arrayLists;
        }


        int small = 1;
        int big = 2;

        // 当超过sum的一半之后，任意两个值相加肯定会大于sum
        // 所以不需要再进行计算了
        int middle = (1 + sum) / 2;

        int curSum = small + big;

        while (small < middle) {

            if (sum == curSum) {
                addArrayList(arrayLists, small, big);

            }

            while (curSum > sum && small < middle) {
                curSum = curSum - small;
                small++;

                if (curSum == sum) {
                    addArrayList(arrayLists, small, big);

                }
            }

            big++;
            curSum += big;
        }

        return arrayLists;
    }

    private void addArrayList(ArrayList<ArrayList<Integer>> arrayLists, int small, int big) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for (int i = small; i <= big; i++) {
            arrayList.add(i);
        }
        arrayLists.add(arrayList);
    }

    @Test
    public void Test() {
        System.out.println(findContinuousSequence(15));
    }
}

package CodingInterviews;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 剑指offer-65-滑动窗口的最大值
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class MaxInWindows {

    public ArrayList<Integer> maxInWindows(int[] num, int size) {

        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        if (num == null || size == 0) {
            return arrayList;
        }

        // 最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        for (int i = 0; i < num.length; i++) {
            queue.add(num[i]);

            // 第一次堆中的数量等于size
            // 此时该窗口中的最大值就是堆顶
            if (i == size - 1) {
                arrayList.add(queue.peek());
            }

            if (queue.size() > size) {
                queue.remove(num[i - size]);
                arrayList.add(queue.peek());
            }
        }

        return arrayList;
    }


}

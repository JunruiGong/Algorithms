package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Leetcode-118-Pascal's Triangle
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (numRows <= 0) {
            return lists;
        }

        for (int i = 0; i < numRows; i++) {
            list.add(0, 1); // 在指定index上插入数据，如果当前位置上存在数据，则该数据会向右移动，size+1。
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }

            lists.add(new ArrayList<>(list));
            // lists.add(list);
            // 此处不能采用list赋值，需要重新new ArrayList，因为每一次循环list都在变化
            // 所以放在lists中的list也会变化，这样导致最后返回的结果是最后一次循环的结果。
            // 举个例子，假如row是5的话，return [[1,4,6,4,1],[1,4,6,4,1],[1,4,6,4,1],[1,4,6,4,1],[1,4,6,4,1]]。
        }

        return lists;
    }

    @Test
    public void Test(){

        generate(5);

    }
}

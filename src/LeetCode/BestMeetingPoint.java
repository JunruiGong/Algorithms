package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Leetcode-296-Word Search-Medium
 *
 * A group of two or more people wants to meet and minimize the total travel distance.
 * You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group.
 * The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 *
 * For example, given three people living at (0,0), (0,4), and (2,2):
 *
 * 1 - 0 - 0 - 0 - 1
 * |   |   |   |   |
 * 0 - 0 - 0 - 0 - 0
 * |   |   |   |   |
 * 0 - 0 - 1 - 0 - 0
 * The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
 *
 * Hint:
 *
 * Try to solve it in one dimension first. How can this solution apply to the two dimension case?
 *
 *
 * ______C_____A_____P_______B______D______
 *
 * 要想找到最佳位置，该位置肯定是在两点之间
 * 假设P点的最佳位置就是在[A, B]区间内，这样四个点到达P的距离之和为: CP+AP+PB+PD = AB+CD，
 * 所以我们知道用最后一个坐标减去第一个坐标，即CD距离，倒数第二个坐标减去第二个坐标，即AB距离，
 * 以此类推，直到最中间停止，结果就是最短距离
 */
public class BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        List<Integer> x = new ArrayList<>();

        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {

                    // 确定每个点的x轴和y轴
                    x.add(i);
                    y.add(j);
                }
            }
        }

        return getMidPoint(x) + getMidPoint(y);
    }

    private int getMidPoint(List<Integer> list) {
        Collections.sort(list);
        int i = 0;
        int j = list.size() - 1;
        int result = 0;

        while (i < j) {
            result += list.get(j--) - list.get(i++);
        }

        return result;
    }
}

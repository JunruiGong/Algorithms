package LeetCode;

/**
 * Leetcode-265-Paint House II-Hard
 *
 * There are a row of n houses, each house can be painted with one of the k colors.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x k cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color 0;
 * costs[1][2]is the cost of painting house 1 with color 2, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 *
 * Follow up:
 * Could you solve it in O(nk) runtime?
 */
public class PaintHouseII {

    public int minCostII(int[][] costs) {
        if (costs == null || costs[0].length < 1) {
            return 0;
        }

        int minColor = -1;  // 产生最小花费的那种颜色
        int min1 = -1;    // 最小的花费
        int min2 = -1;    // 第二小的花费

        for (int i = 0; i < costs.length; i++) {
            int newMinColor = -1;
            int newMin1 = Integer.MAX_VALUE;
            int newMin2 = Integer.MAX_VALUE;
            for (int j = 0; j < costs[0].length; j++) {

                // 如果当前的房子涂了最便宜的的颜色，则上一个房子需要涂第二便宜的颜色
                costs[i][j] = costs[i][j] + (j == minColor ? min2 : min1);

                if (newMin1 > costs[i][j]) {
                    newMin2 = newMin1;
                    newMin1 = costs[i][j];
                    newMinColor = j;

                } else {
                    newMin2 = Math.min(costs[i][j], newMin2);
                }
            }

            minColor = newMinColor;
            min1 = newMin1;
            min2 = newMin2;
        }

        return min1;
    }
}

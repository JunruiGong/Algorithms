package LeetCode;

/**
 * Leetcode-256-Paint House-Easy
 *
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * The cost of painting each house with a certain color is different.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix.
 * For example, costs[0][0] is the cost of painting house 0 with color red;
 * costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.
 *
 * Note:
 * All costs are positive integers.
 */
public class PaintHouse {
    public int minCost(int[][] costs) {

        if (costs == null || costs[0].length < 1) {
            return 0;
        }

        for (int i = 1; i < costs.length; i++) {

            // 涂了第一种的话，那上一个房子只能涂第二种或第三种，从这两种中找到最便宜的一种
            costs[i][0] = costs[i][0] + Math.min(costs[i - 1][1], costs[i - 1][2]);

            // 涂第二种和第三种同理
            costs[i][1] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][2]);
            costs[i][2] = costs[i][1] + Math.min(costs[i - 1][0], costs[i - 1][1]);
        }

        // 在最后一个房子中找到涂三种颜色最小的开销
        return Math.min(costs[costs.length - 1][0], Math.min(costs[costs.length - 1][1], costs[costs.length - 1][2]));
    }
}

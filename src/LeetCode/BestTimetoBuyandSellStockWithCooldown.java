package LeetCode;

/**
 * Leetcode-309-Best Time to Buy and Sell Stock With Cooldown
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 *
 * Input: [1,2,3,0,2]
 * Output: 3
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BestTimetoBuyandSellStockWithCooldown {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int n = prices.length;
        int[] hold = new int[n]; // 第i天结束持有股票的最大profit
        int[] unhold = new int[n];  // 第i天结束不持有股票的最大profit

        /**
         *
         * Base case
         * hold[0] = -prices[0]
         * hold[1] = max(-prices[1], -prices[0])
         * unhold[0] = 0
         *
         *
         * hold[i] 取下面情况的最大值
         * 1. 第i天买入     unhold[i - 2] - prices[i]   (i - 2的原因是：必须中间休息一天)
         * 2. 第i天没有买入  hold[i-1]
         *
         *
         * unhold[i] 取下面情况的最大值
         * 1. 第i天卖出     hold[i - 1] + prices[i]
         * 2. 第i天没有卖出  unhold[i-1]
         *
         */

        hold[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (i == 1) {
                hold[i] = Math.max(hold[i - 1], -prices[i]);
            } else {
                hold[i] = Math.max(hold[i - 1], unhold[i - 2] - prices[i]);
            }

            unhold[i] = Math.max(unhold[i - 1], hold[i - 1] + prices[i]);
        }

        return unhold[n - 1];
    }
}

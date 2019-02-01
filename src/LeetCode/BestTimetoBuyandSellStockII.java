package LeetCode;

/**
 * Leetcode-122-Best Time to Buy and Sell Stock II
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit.
 * You may complete as many transactions as you like
 * (i.e., buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time
 * (i.e., you must sell the stock before you buy again).
 *
 * Example：
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStockII {

    /**
     *
     * 低价买入高价抛出，那么这里我们只需要从第二天开始，
     * 如果当前价格比之前价格高，则把差值加入利润中，
     * 因为我们可以昨天买入，今日卖出，
     * 若明日价更高的话，还可以今日买入，明日再抛出。
     */

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            int prev = prices[i - 1];
            if (curr - prev > 0) {
                sum += (curr - prev);
            }
        }

        return sum;
    }
}

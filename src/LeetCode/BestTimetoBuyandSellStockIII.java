package LeetCode;

/**
 * Leetcode-123-Best Time to Buy and Sell Stock III
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 * Example 1:
 *
 * Input: [3,3,5,0,0,3,1,4]
 * Output: 6
 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 *              Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStockIII {
    public int maxProfit(int[] prices) {

        if (prices == null || prices.length < 2) {
            return 0;
        }

        int buy1 = Integer.MAX_VALUE;
        int afterSell1 = 0;
        int afterBuy2 = Integer.MIN_VALUE;
        int afterSell2 = 0;

        for (int price : prices) {

            // 第一次购买的钱越少越好
            buy1 = Math.min(buy1, price);

            // 第一次卖出之后，获得的钱越多越好
            afterSell1 = Math.max(afterSell1, price - buy1);

            // 第二次买入，用第一次交易的利润做第二次买入后获得的利润，越大越好
            afterBuy2 = Math.max(afterBuy2, afterSell1 - price);

            // 第二次卖出，获得的利润越大越好
            afterSell2 = Math.max(afterSell2, afterBuy2 + price);
        }

        return afterSell2;
    }
}

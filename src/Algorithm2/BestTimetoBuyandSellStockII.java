package Algorithm2;

import org.junit.Test;

public class BestTimetoBuyandSellStockII {
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

    @Test
    public void test(){

        int[] prices={1,2,3,4,5};
        System.out.println(maxProfit(prices));

    }

}

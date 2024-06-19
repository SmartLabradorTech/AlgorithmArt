package stock;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/?envType=study-plan-v2&envId=top-interview-150

public class BestTimetoBuyandSell2 {
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            int delta = prices[i] - prices[i - 1];

            if (delta > 0) {
                profit += delta;
            }

        }

        return profit;

    }

}

package stock;

import java.util.Arrays;

public class BestTimetoBuyandSellStockIV {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

    public int maxProfit(int k, int[] prices) {

        int[] cost = new int[k];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = prices[0];

        int[] profit = new int[k];

        for (int i = 1; i < prices.length; i++) {
            profit[0] = Math.max(profit[0], prices[i] - cost[0]);

            cost[0] = Math.min(cost[0], prices[i]);

            for (int j = 1; j < k; j++) {

                cost[j] = Math.min(cost[j], prices[i] - profit[j - 1]);

                profit[j] = Math.max(profit[j], prices[i] - cost[j]);
            }

        }

        return profit[k - 1];
    }

    public static void main(String[] args) {

        BestTimetoBuyandSellStockIV bb = new BestTimetoBuyandSellStockIV();

        int[] prices = { 3, 2, 6, 5, 0, 3 };

        System.out.println(bb.maxProfit(2, prices));
    }

}

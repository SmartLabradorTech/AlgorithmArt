package stock;

public class BestTimetoBuyandSellStockIVV3 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

    public int maxProfit(int k, int[] prices) {

        int days = prices.length;

        // first: index of days.
        // second: transcations already made
        // third: 0 for no stock or 1 for with stock
        int[][][] profit = new int[days][k*2+1][2];

        for (int trans = 0; trans <= k; trans++) {

            profit[0][trans][0]
        }

        for (int i = 0; i < days; i++) {

            for (int trans = 0; trans <= k; trans++) {

                profit[i][trans][0] = Math.max(profit[i - 1][trans][0], profit[i - 1][trans - 1][1] + prices[i]);

                profit[i][trans][1] = Math.max(profit[i - 1][trans - 1][0] - prices[i], profit[i - 1][trans][1]);
            }

        }

        return 0;
    }

    public static void main(String[] args) {

        BestTimetoBuyandSellStockIVV2 bb = new BestTimetoBuyandSellStockIVV2();

        int[] prices = { 3, 2, 6, 5, 0, 3 };

        System.out.println(bb.maxProfit(2, prices));
    }

}

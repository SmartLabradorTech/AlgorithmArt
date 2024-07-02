package stock;

public class BestTimetoBuyandSell3V3 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

    public int maxProfit(int[] prices) {
        int firstCost = prices[0];
        int firstProfit = 0;

        int secondCost = prices[0];

        int secondProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            firstProfit = Math.max(firstProfit, prices[i] - firstCost);

            firstCost = Math.min(firstCost, prices[i]);

            secondCost = Math.min(secondCost, prices[i] - firstProfit);

            secondProfit = Math.max(secondProfit, prices[i] - secondCost);
        }

        return secondProfit;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSell3V3 bb = new BestTimetoBuyandSell3V3();

        int[] prices = { 1, 2 };

        System.out.println(bb.maxProfit(prices));

    }
}

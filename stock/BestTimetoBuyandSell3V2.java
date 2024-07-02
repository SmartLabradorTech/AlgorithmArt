package stock;

public class BestTimetoBuyandSell3V2 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

    public int maxProfit(int[] prices) {

        int[] maxEndAt = calculateEndAt(prices);

        int[] maxStartWith = calcuateStartWith(prices);

        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            max = Math.max(max, maxEndAt[i] + maxStartWith[i]);

        }

        return max;
    }

    public int[] calculateEndAt(int[] prices) {

        int[] maxEndAt = new int[prices.length];

        int minSoFar = prices[0];

        int max = 0;

        for (int i = 1; i < prices.length; i++) {

            max = Math.max(max, prices[i] - minSoFar);

            maxEndAt[i] = max;

            minSoFar = Math.min(minSoFar, prices[i]);

        }

        return maxEndAt;
    }

    public int[] calcuateStartWith(int[] prices) {
        int[] maxStartWith = new int[prices.length];

        int maxSoFar = prices[prices.length - 1];

        int max = 0;

        for (int i = prices.length - 2; i >= 0; i--) {

            max = Math.max(max, maxSoFar - prices[i]);

            maxStartWith[i] = max;

            maxSoFar = Math.max(maxSoFar, prices[i]);

        }

        return maxStartWith;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSell3V2 bb = new BestTimetoBuyandSell3V2();

        int[] prices = { 1, 2 };

        System.out.println(bb.maxProfit(prices));

    }
}

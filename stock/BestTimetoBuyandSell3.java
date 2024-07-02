package stock;

public class BestTimetoBuyandSell3 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

    public int maxProfit(int[] prices) {
        int max = 0;

        for (int i = 0; i < prices.length; i++) {

            max = Math.max(max, max(0, i, prices) + max(i, prices.length - 1, prices));

        }

        return max;
    }

    public int max(int start, int end, int[] prices) {

        int minSoFar = prices[start];
        int maxPro = 0;

        for (int i = start + 1; i <= end; i++) {

            maxPro = Math.max(prices[i] - minSoFar, maxPro);

            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return maxPro;
    }

    public static void main(String[] args) {
        BestTimetoBuyandSell3 bb = new BestTimetoBuyandSell3();

        int[] prices = { 1, 2 };

        System.out.println(bb.maxProfit(prices));

    }
}

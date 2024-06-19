package stock;

public class BestTimetoBuyandSell {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];

        int max = 0;

        for (int i = 1; i < prices.length; i++) {

            int profit = prices[i] - minSoFar;

            max = Math.max(max, profit);

            minSoFar = Math.min(minSoFar, prices[i]);
        }

        return max;
    }

    public static void main(String[] args) {

    }
}

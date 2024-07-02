package stock;

public class BestTimetoBuyandSellStockIVV2 {

    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/

    // not working yet.
    public int maxProfit(int k, int[] prices) {

        int days = prices.length;

        int[][][] profit = new int[days][days][k + 1];

        for (int i = 0; i < days; i++) {
            for (int j = i; j < days; j++) {

                int max = 0;
                int minSoFar = prices[i];

                for (int m = i + 1; m <= j; m++) {

                    max = Math.max(max, prices[m] - minSoFar);

                    minSoFar = Math.min(minSoFar, prices[m]);
                }

                profit[i][j][1] = max;
            }
        }

        for (int i = 2; i <= k; i++) {

            for (int j = 0; j < days; j++) {

                for (int s = j; s < days; s++) {

                    int max = 0;

                    for (int q = j; q <= s; q++) {

                        max = Math.max(max, profit[j][q][k - 1] + profit[q][s][1]);
                    }

                    profit[j][s][i] = max;

                }

            }

        }

        return profit[0][days - 1][k];
    }

    public static void main(String[] args) {

        BestTimetoBuyandSellStockIVV2 bb = new BestTimetoBuyandSellStockIVV2();

        int[] prices = { 3, 2, 6, 5, 0, 3 };

        System.out.println(bb.maxProfit(2, prices));
    }

}

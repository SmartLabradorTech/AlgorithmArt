package Candy;

public class CandyV4 {

    // write O(1) space by self

    private int calcuate(int n) {

        return (n * (n + 1)) / 2;
    }

    public int candy(int[] ratings) {

        int up = 0;

        int down = 0;

        int newSlope = 0;

        int oldSlope = 0;

        int count = 0;

        for (int i = 1; i < ratings.length; i++) {
            // calcuate new slope

            if (ratings[i] > ratings[i - 1]) {
                newSlope = 1;
            } else if (ratings[i] < ratings[i - 1]) {
                newSlope = -1;
            } else {
                newSlope = 0;
            }

            // new count
            if ((oldSlope > 0 && newSlope == 0) || (oldSlope < 0 && newSlope >= 0)) {
                count += (calcuate(up) + calcuate(down) + Math.max(up, down));

                up = 0;

                down = 0;
            }

            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                count++;
            }

            oldSlope = newSlope;

        }

        count += (calcuate(up) + calcuate(down) + Math.max(up, down) + 1);

        return count;
    }

    public static void main(String[] args) {

        CandyV4 cs = new CandyV4();

        int[] ratings = { 1, 0, 2 };

        System.out.println(cs.candy(ratings));
    }
}

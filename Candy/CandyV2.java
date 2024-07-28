package Candy;

import java.util.Arrays;

public class CandyV2 {

    public int candy(int[] ratings) {
        int length = ratings.length;

        int[] count = new int[length];

        Arrays.fill(count, 1);

        for (int i = 1; i < length; i++) {
            // look left

            if (ratings[i] > ratings[i - 1] && count[i] <= count[i - 1]) {
                count[i] = count[i - 1] + 1;
            }

        }

        for (int i = length - 2; i >= 0; i--) {

            if (ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                count[i] = count[i + 1] + 1;
            }
        }

        int result = 0;

        for (int i = 0; i < length; i++) {
            result += count[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] ratings = { 1, 2, 3, 4, 5, 3, 2, 1, 2, 6, 5, 4, 3, 3, 2, 1, 1, 3, 3, 3, 4, 2 };

        CandyV2 cs = new CandyV2();

        System.out.println(cs.candy(ratings));
    }
}

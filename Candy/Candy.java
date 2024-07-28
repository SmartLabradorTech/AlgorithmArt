package Candy;

import java.util.Arrays;

public class Candy {

    // https://leetcode.com/problems/candy/?envType=study-plan-v2&envId=top-interview-150

    public int candy(int[] ratings) {
        int length = ratings.length;

        int[] count = new int[length];

        Arrays.fill(count, 1);

        boolean needAdjust = true;

        while (needAdjust) {
            boolean updated = false;

            for (int i = 0; i < length; i++) {

                // check left
                if (i - 1 >= 0) {

                    if (ratings[i] > ratings[i - 1] && count[i] <= count[i - 1]) {
                        count[i] = count[i - 1] + 1;
                        updated = true;
                    }

                }

                // check right
                if (i + 1 < length) {

                    if (ratings[i] > ratings[i + 1] && count[i] <= count[i + 1]) {
                        count[i] = count[i + 1] + 1;
                        updated = true;
                    }

                }

            }

            if (!updated) {
                needAdjust = false;
            }

        }

        int result = 0;

        for (int i = 0; i < length; i++) {
            result += count[i];
        }

        return result;
    }

}

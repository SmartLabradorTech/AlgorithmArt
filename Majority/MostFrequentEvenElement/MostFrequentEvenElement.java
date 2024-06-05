package Majority.MostFrequentEvenElement;

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();

        int maxCount = 0;
        int target = 0;

        for (int i = 0; i < nums.length; i++) {

            int current = nums[i];

            if (current % 2 == 1) {
                continue;
            }

            int newCount = 1;

            if (count.containsKey(current)) {
                newCount = count.get(current) + 1;
            }

            count.put(current, newCount);

            if (maxCount < newCount) {
                maxCount = newCount;
                target = current;
            } else if (maxCount == newCount) {

                target = Math.min(target, current);
            }

        }

        if (maxCount == 0) {
            return -1;
        }

        return target;
    }

    public static void main(String[] args) {

        int[] nums = { 29, 47, 21, 41, 13, 37, 25, 7 };

    }

}

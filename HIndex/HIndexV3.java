package HIndex;

import java.util.Arrays;
import java.util.Collections;

public class HIndexV3 {

    public int hIndex(int[] citations) {

        Integer[] array = Arrays.stream(citations).boxed().toArray(Integer[]::new);

        Arrays.sort(array, Collections.reverseOrder());

        // System.out.println(Arrays.toString(array));

        int i = 0;

        for (; i < array.length; i++) {

            if (array[i] > i) {

            } else {
                break;
            }

        }

        return i;
    }

    public static void main(String[] args) {

        HIndexV3 hi = new HIndexV3();

        int[] nums = { 3, 0, 6, 1, 5 };

        System.out.println(hi.hIndex(nums));
    }

}

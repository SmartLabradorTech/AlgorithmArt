package array.LongestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefixV4 {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> prefix = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];

            while (num > 0) {
                prefix.add(num);
                num = num / 10;
            }
        }

        int max = 0;

        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];

            while (num > 0) {

                if (prefix.contains(num)) {
                    max = Math.max(max, num);
                }

                num = num / 10;

            }

        }

        if (max == 0) {
            return 0;
        }

        return Integer.toString(max).length();
    }

    public static void main(String[] args) {
        LongestCommonPrefixV4 lp = new LongestCommonPrefixV4();

        // int[] arr1 = { 1, 10, 100 };
        // int[] arr2 = { 1000 };

        // int[] arr1 = { 10 };
        // int[] arr2 = { 17, 11 };

        int[] arr1 = { 13, 27, 45 };
        int[] arr2 = { 21, 27, 48 };
        // int[] arr1 = { 27 };
        // int[] arr2 = { 27 };

        // int[] arr1 = { 1, 2, 3 };
        // int[] arr2 = { 4, 4, 4 };

        System.out.println(lp.longestCommonPrefix(arr1, arr2));

    }

}

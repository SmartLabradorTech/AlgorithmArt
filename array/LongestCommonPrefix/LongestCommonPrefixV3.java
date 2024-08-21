package array.LongestCommonPrefix;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonPrefixV3 {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Set<Integer> prefix = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {

            String current = Integer.toString(arr1[i]);

            int num = current.charAt(0) - '0';
            prefix.add(num);

            for (int j = 1; j < current.length(); j++) {

                num = (num * 10 + current.charAt(j) - '0');

                prefix.add(num);
            }
        }

        int longest = 0;

        for (int i = 0; i < arr2.length; i++) {
            String current = Integer.toString(arr2[i]);

            int num = current.charAt(0) - '0';

            if (prefix.contains(num)) {
                longest = Math.max(longest, 1);
            }

            for (int j = 1; j < current.length(); j++) {

                num = (num * 10 + current.charAt(j) - '0');

                if (prefix.contains(num)) {
                    longest = Math.max(longest, Integer.toString(num).length());
                }
            }

        }

        return longest;
    }

    public static void main(String[] args) {
        LongestCommonPrefixV3 lp = new LongestCommonPrefixV3();

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

package array.LongestCommonPrefix;
// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/

public class LongestCommonPrefix {

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        int result = 0;

        for (int i = 0; i < arr1.length; i++) {

            for (int j = 0; j < arr2.length; j++) {

                result = Math.max(result, check(arr1[i], arr2[j]));
            }
        }

        return result;
    }

    private int check(int num1, int num2) {

        String string1 = Integer.toString(num1);
        String string2 = Integer.toString(num2);

        int common = 0;

        for (int i = 0; i < string1.length(); i++) {

            if (i >= string2.length() || string1.charAt(i) != string2.charAt(i)) {
                return common;
            } else {
                common++;
            }

        }

        return common;
    }

    public static void main(String[] args) {

        LongestCommonPrefix lp = new LongestCommonPrefix();

        int[] arr1 = { 1, 10, 100 };
        int[] arr2 = { 1000 };

        System.out.println(lp.longestCommonPrefix(arr1, arr2));

        // System.out.println(Integer.toString(123));

    }
}

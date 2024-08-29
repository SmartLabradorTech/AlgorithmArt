package string.PalindromeNumber;

/**
 * PalindromeNumber
 * 
 * https://leetcode.com/problems/palindrome-number/description/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int convert = 0;

        int input = x;

        while (x > 0) {

            int low = x % 10;

            convert = convert * 10 + low;

            x = x / 10;
        }

        return input == convert;
    }
}

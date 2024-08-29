package string.ValidPalindrome;

// https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isLetterOrDigit(currentChar)) {

                buffer.append(Character.toUpperCase(currentChar));
            }

        }

        String clean = buffer.toString();

        for (int i = 0, j = clean.length() - 1; i < j;) {

            if (clean.charAt(i) != clean.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}

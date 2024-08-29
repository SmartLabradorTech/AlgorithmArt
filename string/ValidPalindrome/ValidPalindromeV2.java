package string.ValidPalindrome;

public class ValidPalindromeV2 {

    public boolean isPalindrome(String s) {

        for (int i = 0, j = s.length() - 1; i < j;) {

            if (Character.isLetterOrDigit(s.charAt(i))) {
                if (Character.isLetterOrDigit(s.charAt(j))) {
                    // compare

                    if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
                        i++;
                        j--;
                    } else {
                        return false;
                    }

                } else {

                    j--;
                }

            } else {
                i++;
            }

        }

        return true;
    }
}

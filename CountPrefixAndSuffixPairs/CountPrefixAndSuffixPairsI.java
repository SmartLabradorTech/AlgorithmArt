package CountPrefixAndSuffixPairs;

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/

public class CountPrefixAndSuffixPairsI {

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        for (int i = 0; i < words.length; i++) {

            for (int j = i + 1; j < words.length; j++) {

                if (isValid(words[i], words[j])) {

                    count++;
                }

            }

        }

        return count;
    }

    private boolean isValid(String s1, String s2) {

        for (int i = 0; i < s1.length(); i++) {

            if (i >= s2.length() || s1.charAt(i) != s2.charAt(i)) {
                return false;
            }

            if (s2.length() - 1 - i < 0 || s1.charAt(s1.length() - 1 - i) != s2.charAt(s2.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}

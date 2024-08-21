package array.LongestCommonSuffixQueries;

// https://leetcode.com/problems/longest-common-suffix-queries/description/

public class LongestCommonSuffixQueries {

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int length = wordsQuery.length;

        int[] result = new int[length];

        for (int i = 0; i < length; i++) {

            result[i] = handle(wordsContainer, wordsQuery[i]);
        }

        return result;
    }

    private int handle(String[] wordsContainer, String query) {

        int index = -1;
        int commonMax = -1;

        for (int i = 0; i < wordsContainer.length; i++) {

            int common = suffix(wordsContainer[i], query);

            // find a new candidate
            if (common > commonMax) {

                commonMax = common;
                index = i;
            } else if (common == commonMax) {

                // need to compare length.

                if (wordsContainer[i].length() < wordsContainer[index].length()) {
                    index = i;
                }

            }

        }

        return index;
    }

    private int suffix(String container, String query) {
        int common = 0;

        for (int i = 0; i < query.length(); i++) {

            if (container.length() - 1 - i < 0
                    || query.charAt(query.length() - 1 - i) != container.charAt(container.length() - 1 - i)) {

                return common;
            } else {
                common++;
            }

        }

        return common;
    }
}

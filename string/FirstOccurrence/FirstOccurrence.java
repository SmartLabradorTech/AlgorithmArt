package string.FirstOccurrence;

// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

public class FirstOccurrence {
    public int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {

            boolean found = true;

            for (int j = 0; j < needle.length(); j++) {

                if (i + j >= haystack.length() || needle.charAt(j) != haystack.charAt(i + j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }

        }

        return -1;
    }
}

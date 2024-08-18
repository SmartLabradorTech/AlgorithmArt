package string.LongestCommonPrefix;
// https://leetcode.com/problems/longest-common-prefix/description/?envType=study-plan-v2&envId=top-interview-150

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        // use strs[0] as base.

        int validIndex = -1;

        for (int i = 0; i < strs[0].length(); i++) {

            // check if all others are same.

            boolean same = true;

            for (int j = 1; j < strs.length; j++) {

                String s = strs[j];

                if (i >= s.length() || s.charAt(i) != strs[0].charAt(i)) {
                    same = false;
                    break;
                }

            }

            if (same) {
                validIndex = i;
            } else {
                break;
            }

        }

        if (validIndex == -1) {
            return "";
        }

        return strs[0].substring(0, validIndex + 1);
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        return prefix;
    }
}

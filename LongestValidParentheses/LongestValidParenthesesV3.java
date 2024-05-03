package LongestValidParentheses;

import java.util.Stack;

// problem https://leetcode.com/problems/longest-valid-parentheses/

class LongestValidParenthesesV3 {

    public int longestValidParentheses(String s) {

        if (s.length() < 2) {
            return 0;
        }

        int[] dp = new int[s.length()];

        dp[0] = 0;
        dp[1] = (s.charAt(0) == '(' && s.charAt(1) == ')') ? 2 : 0;

        int max = dp[1];

        for (int i = 2; i < s.length(); i++) {
            char current = s.charAt(i);

            if (current == '(') {
                dp[i] = 0;
                continue;
            }
            // check previous
            char previous = s.charAt(i - 1);

            if (previous == '(') {
                dp[i] = dp[i - 2] + 2;
            } else {
                if (dp[i - 1] == 0) {
                    continue;
                }

                int previousStartIndex = i - dp[i - 1];

                // check the previous char

                if (previousStartIndex > 0 && s.charAt(previousStartIndex - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + (previousStartIndex - 2 >= 0 ? dp[previousStartIndex - 2] : 0);
                } else {
                    dp[i] = 0;
                }

            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {

        LongestValidParenthesesV3 p = new LongestValidParenthesesV3();

        System.out.println("*********");

        // System.out.println(p.longestValidParentheses("()"));

        // System.out.println(p.longestValidParentheses("(()"));

        // System.out.println(p.longestValidParentheses(")()())"));

        System.out.println(p.longestValidParentheses(")))"));

    }
}
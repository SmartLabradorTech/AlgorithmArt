package LongestValidParentheses;

import java.util.Stack;

// problem https://leetcode.com/problems/longest-valid-parentheses/

class LongestValidParentheses {

    private boolean isValid(String s) {

        Stack stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            Character currenCharacter = s.charAt(i);
            if (currenCharacter == '(') {
                stack.push(currenCharacter);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    public int longestValidParentheses(String s) {

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {

                // check each substring

                if (isValid(s.substring(i, j + 1))) {
                    max = Math.max(max, j - i + 1);
                }

            }
        }

        return max;
    }

    public static void main(String[] args) {

        LongestValidParentheses p = new LongestValidParentheses();

        // System.out.println(p.longestValidParentheses("(()"));

        System.out.println(p.longestValidParentheses(")()())"));

    }
}
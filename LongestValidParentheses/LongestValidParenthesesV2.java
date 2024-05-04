package LongestValidParentheses;

import java.util.Stack;

// problem https://leetcode.com/problems/longest-valid-parentheses/

class LongestValidParenthesesV2 {

    // private boolean isValid(String s) {

    // Stack stack = new Stack<Character>();

    // for (int i = 0; i < s.length(); i++) {
    // Character currenCharacter = s.charAt(i);
    // if (currenCharacter == '(') {
    // stack.push(currenCharacter);
    // } else {
    // if (stack.isEmpty()) {
    // return false;
    // }

    // stack.pop();
    // }
    // }

    // return stack.isEmpty();
    // }

    public int longestValidParentheses(String s) {

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);

            if (charAt == ')') {
                continue;
            }

            Stack stack = new Stack<Character>();

            stack.push(charAt);

            for (int j = i + 1; j < s.length(); j++) {
                char currenCharacter = s.charAt(j);

                if (currenCharacter == '(') {
                    stack.push(currenCharacter);
                } else {
                    // need to check

                    if (stack.isEmpty()) {
                        // no need to check further
                        break;
                    }

                    stack.pop();

                    if (stack.isEmpty()) {
                        // calcuate
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        LongestValidParenthesesV2 p = new LongestValidParenthesesV2();

        System.out.println(p.longestValidParentheses("(()"));

        // System.out.println(p.longestValidParentheses(")()())"));

    }
}
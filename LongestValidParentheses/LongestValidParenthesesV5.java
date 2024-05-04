package LongestValidParentheses;

import java.util.Stack;

// problem https://leetcode.com/problems/longest-valid-parentheses/

class LongestValidParenthesesV5 {

    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(-1);

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        LongestValidParenthesesV5 p = new LongestValidParenthesesV5();

        System.out.println("*********");

        System.out.println(p.longestValidParentheses("()"));

        // System.out.println(p.longestValidParentheses("(()"));

        // System.out.println(p.longestValidParentheses(")()())"));

        // System.out.println(p.longestValidParentheses(")))"));

        // System.out.println(p.longestValidParentheses("(()(()))"));

    }
}
package LongestValidParentheses;

// problem https://leetcode.com/problems/longest-valid-parentheses/

class LongestValidParenthesesV4 {

    public int longestValidParentheses(String s) {

        int left = 0;
        int right = 0;

        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;

            } else {
                right++;
            }

            if (left < right) {
                left = 0;
                right = 0;
            } else if (left == right) {
                max = Math.max(max, left * 2);
            }
        }

        // rest left and right

        left = 0;

        right = 0;

        for (int j = s.length() - 1; j >= 0; j--) {
            if (s.charAt(j) == '(') {
                left++;
            } else {
                right++;
            }

            if (left > right) {
                left = 0;
                right = 0;
            } else if (left == right) {
                max = Math.max(max, 2 * left);
            }

        }

        return max;

    }

    public static void main(String[] args) {

        LongestValidParenthesesV4 p = new LongestValidParenthesesV4();

        System.out.println("*********");

        System.out.println(p.longestValidParentheses("()"));

        // System.out.println(p.longestValidParentheses("(()"));

        // System.out.println(p.longestValidParentheses(")()())"));

        // System.out.println(p.longestValidParentheses(")))"));

        // System.out.println(p.longestValidParentheses("(()(()))"));

    }
}
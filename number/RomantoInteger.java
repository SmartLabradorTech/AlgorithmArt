package number;

// https://leetcode.com/problems/roman-to-integer/?envType=study-plan-v2&envId=top-interview-150

public class RomantoInteger {
    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();

        for (int i = 0; i < length; i++) {

            char current = s.charAt(i);

            if (current == 'M') {
                result += 1000;
            } else if (current == 'D') {
                result += 500;
            } else if (current == 'C') {

                if (i == length - 1) {
                    result += 100;
                    break;
                }

                char next = s.charAt(i + 1);
                if (next == 'D') {
                    result += 400;
                    i++;
                } else if (next == 'M') {
                    result += 900;
                    i++;
                } else {
                    result += 100;
                }
            } else if (current == 'L') {
                result += 50;
            } else if (current == 'X') {

                if (i == length - 1) {
                    result += 10;
                    break;
                }

                char next = s.charAt(i + 1);

                if (next == 'L') {
                    result += 40;
                    i++;
                } else if (next == 'C') {
                    result += 90;
                    i++;
                } else {
                    result += 10;
                }
            } else if (current == 'V') {
                result += 5;
            } else if (current == 'I') {

                if (i == length - 1) {
                    result += 1;
                    break;
                }

                char next = s.charAt(i + 1);

                if (next == 'V') {
                    result += 4;
                    i++;
                } else if (next == 'X') {
                    result += 9;
                    i++;
                } else {
                    result += 1;
                }
            }
        }

        return result;
    }
}

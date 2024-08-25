package string.ZigzagConversion;

// https://leetcode.com/problems/zigzag-conversion/?envType=study-plan-v2&envId=top-interview-150

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        Character[][] grid = new Character[numRows][s.length()];
        int col = 0;

        for (int i = 0; i < s.length();) {

            for (int j = 0; j < numRows && i < s.length(); j++) {
                grid[j][col] = s.charAt(i);
                i++;
            }

            if (i == s.length()) {
                break;
            }

            for (int m = 1; m <= numRows - 2 && i < s.length(); m++) {
                col++;
                grid[numRows - 1 - m][col] = s.charAt(i);

                i++;
            }

            if (i == s.length()) {
                break;
            }

            col++;

        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numRows; i++) {

            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] != null) {
                    result.append(grid[i][j]);
                }

            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        ZigzagConversion zc = new ZigzagConversion();

        System.out.println(zc.convert("PAYPALISHIRING", 3));
    }
}

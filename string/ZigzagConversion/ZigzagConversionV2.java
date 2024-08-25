package string.ZigzagConversion;

// use formula.

public class ZigzagConversionV2 {

    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int length = s.length();

        int numsInSelection = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            // handle row with index i.

            if (i == 0 || i == numRows - 1) {

                int startIndex = 0;

                if (i == numRows - 1) {
                    startIndex = numRows - 1;
                }

                while (startIndex < length) {

                    sb.append(s.charAt(startIndex));

                    startIndex += numsInSelection;
                }
            } else {

                int delta = numsInSelection - 2 * i;

                int startIndex = i;

                boolean inside = true;
                while (startIndex < length) {

                    sb.append(s.charAt(startIndex));

                    if (inside) {
                        startIndex += delta;
                        inside = !inside;
                    } else {
                        startIndex = startIndex - delta + numsInSelection;
                        inside = !inside;
                    }
                }

            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {

        ZigzagConversionV2 zc = new ZigzagConversionV2();

        System.out.println(zc.convert("PAYPALISHIRING", 3));

        System.out.println(zc.convert("A", 1));

    }
}

package number;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/integer-to-english-words/description/
public class IntegertoEnglishWords {

    int billion = 1000000000;
    int million = 1000000;
    int thousand = 1000;
    int hundred = 100;
    int ten = 10;

    Map<Integer, String> base = new HashMap<>();

    public String numberToWords(int num) {
        base.put(0, "Zero");
        base.put(1, "One");
        base.put(2, "Two");
        base.put(3, "Three");
        base.put(4, "Four");
        base.put(5, "Five");
        base.put(6, "Six");
        base.put(7, "Seven");
        base.put(8, "Eight");
        base.put(9, "Nine");

        base.put(10, "Ten");
        base.put(20, "Twenty");
        base.put(30, "Thirty");
        base.put(40, "Forty");
        base.put(50, "Fifty");
        base.put(60, "Sixty");
        base.put(70, "Seventy");
        base.put(80, "Eighty");
        base.put(90, "Ninety");

        base.put(11, "Eleven");
        base.put(12, "Twelve");
        base.put(13, "Thirteen");
        base.put(14, "Fourteen");
        base.put(15, "Fifteen");
        base.put(16, "Sixteen");
        base.put(17, "Seventeen");
        base.put(18, "Eighteen");
        base.put(19, "Nineteen");

        if (num == 0) {
            return base.get(num);
        }

        String words = "";

        int billionUnit = num / billion;

        boolean hasPrevious = false;

        if (billionUnit > 0) {
            words += base.get(billionUnit) + " " + "Billion";
            hasPrevious = true;

            num = num % billion;
        }

        int millionUnit = num / million;

        if (millionUnit > 0) {
            if (hasPrevious) {
                words += " ";
            }

            words += segment(millionUnit) + " " + "Million";

            num = num % million;
            hasPrevious = true;

        }

        int thousandUnit = num / thousand;

        if (thousandUnit > 0) {
            if (hasPrevious) {
                words += " ";
            }

            words += segment(thousandUnit) + " " + "Thousand";
            num = num % thousand;
            hasPrevious = true;
        }

        if (num > 0) {
            if (hasPrevious) {
                words += " ";
            }

            words += segment(num);
        }

        return words;
    }

    private String segment(int num) {
        String result = "";
        boolean hasPrevious = false;

        int hundredUnit = num / hundred;

        if (hundredUnit > 0) {
            result += base.get(hundredUnit) + " Hundred";

            num = num % hundred;

            hasPrevious = true;
        }

        int tenUnit = num / ten;

        if (tenUnit > 0) {
            if (hasPrevious) {
                result += " ";
            }

            if (tenUnit == 1) {
                result += base.get(num);
                return result;
            } else {
                result += base.get(tenUnit * 10);
            }

            num = num % ten;

            hasPrevious = true;
        }

        if (num > 0) {

            if (hasPrevious) {
                result += " ";
            }

            result += base.get(num);

        }

        return result;

    }

    public static void main(String[] args) {

        IntegertoEnglishWords ie = new IntegertoEnglishWords();

        System.out.println(ie.numberToWords(Integer.MAX_VALUE));

    }
}

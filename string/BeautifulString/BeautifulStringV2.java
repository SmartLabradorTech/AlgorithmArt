package string.BeautifulString;

public class BeautifulStringV2 {

    public String shortestBeautifulSubstring(String s, int k) {

        int start = 0;
        int end = 0;
        String target = "";

        int onesSoFar = 0;

        while (end < s.length()) {
            if (s.charAt(end) == '1') {
                onesSoFar++;

                if (onesSoFar == k) {

                    // move start to 1
                    while (start < s.length() && s.charAt(start) != '1') {
                        start++;
                    }

                    String newCandidate = s.substring(start, end + 1);

                    if (target.isEmpty()) {
                        target = newCandidate;
                    } else {
                        if (newCandidate.length() < target.length()) {
                            target = newCandidate;
                        } else if (newCandidate.length() == target.length()) {

                            if (newCandidate.compareTo(target) < 0) {
                                target = newCandidate;
                            }

                        }
                    }

                    // trigger next
                    end++;

                    start++;
                    onesSoFar--;

                    while (start < s.length() && s.charAt(start) != '1') {
                        start++;
                    }
                } else {
                    end++;
                }
            } else {
                end++;
            }

        }

        return target;
    }

    public static void main(String[] args) {

        BeautifulStringV2 bs = new BeautifulStringV2();

        // String input = "100011001";
        // int k = 3;

        // String input = "1011";
        // int k = 2;

        // String input = "000";

        // int k = 1;

        String input = "01011101000111110";
        int k = 5;

        System.out.println(bs.shortestBeautifulSubstring(input, k));
    }
}

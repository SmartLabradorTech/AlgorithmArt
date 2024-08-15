package string.BeautifulString;

// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/description/

public class BeautifulString {
    public String shortestBeautifulSubstring(String s, int k) {

        String target = "";

        for (int i = 0; i < s.length(); i++) {
            int count = 0;

            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == '1') {
                    count++;
                }

                if (count == k) {

                    if (target.isEmpty()) {
                        target = s.substring(i, j + 1);
                    } else {
                        String newCandidate = s.substring(i, j + 1);
                        if (newCandidate.length() < target.length()) {
                            target = newCandidate;
                        } else if (newCandidate.length() == target.length()) {

                            if (newCandidate.compareTo(target) < 0) {
                                target = newCandidate;
                            }

                        }

                    }

                }

            }
        }

        return target;
    }

    public static void main(String[] args) {

        BeautifulString bs = new BeautifulString();

        String input = "100011001";
        int k = 3;

        System.out.println(bs.shortestBeautifulSubstring(input, k));
    }
}

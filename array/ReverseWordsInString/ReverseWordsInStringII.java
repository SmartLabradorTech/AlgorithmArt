package array.ReverseWordsInString;

// https://leetcode.com/problems/reverse-words-in-a-string-ii/description/

public class ReverseWordsInStringII {

    public void reverseWords(char[] s) {

        char[] chars = s;

        int next = chars.length;

        for (int i = 0; i <= (next - 1) / 2; i++) {

            int index = next - 1 - i;

            char temp = chars[i];

            chars[i] = chars[index];

            chars[index] = temp;
        }

        int start = 0;

        int end = 0;

        while (end < next) {

            while (end < next && chars[end] != ' ') {
                end++;
            }

            int mid = (start + end - 1) / 2;

            for (int i = start; i <= mid; i++) {

                int index = end - 1 - i + start;

                char temp = chars[i];

                chars[i] = chars[index];

                chars[index] = temp;
            }

            end++;

            start = end;

        }
    }

    public static void main(String[] args) {

        ReverseWordsInStringII rs = new ReverseWordsInStringII();

        rs.reverseWords("hello   world".toCharArray());
    }
}

package array.ReverseWordsInString;

public class ReverseWordsInStringV2 {

    public String reverseWords(String s) {

        char[] chars = s.toCharArray();

        int next = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == ' ') {

            } else {
                if (next != 0 && i - 1 > 0 && chars[i - 1] == ' ') {
                    chars[next] = ' ';
                    next++;
                }

                // find a valid char. Need to put in good position.
                chars[next] = chars[i];

                next++;
            }

        }

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

        String result = "";

        for (int i = 0; i < next; i++) {
            result += chars[i];
        }

        return result;
    }

    public static void main(String[] args) {

        ReverseWordsInStringV2 rs = new ReverseWordsInStringV2();

        System.out.println(rs.reverseWords("  hello world  ") + "&&");

    }
}

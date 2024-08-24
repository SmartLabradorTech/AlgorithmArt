
package array.ReverseWordsInString;

import java.util.ArrayList;
import java.util.List;

/**
 * ReverseWordsInString
 */
public class ReverseWordsInString {

    public String reverseWords(String s) {

        s = s.trim();

        String[] splits = s.split(" ");

        List<String> result = new ArrayList<>();

        for (int i = splits.length - 1; i >= 0; i--) {
            if (splits[i].isEmpty()) {
                continue;
            }

            result.add(splits[i]);
        }

        return String.join(" ", result);
    }

    public static void main(String[] args) {

        ReverseWordsInString rw = new ReverseWordsInString();

        System.out.println(rw.reverseWords("a good   example"));
    }
}
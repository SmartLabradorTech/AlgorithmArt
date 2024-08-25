package array.TextJustification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {

        List<String> result = new ArrayList<>();

        int startIndex = 0;

        int runningLength = 0;

        for (int i = 0; i < words.length && startIndex < words.length; i++) {

            if (words[i].equals("explain")) {
                int a = 1;
            }

            int attempt = runningLength + words[i].length();

            // more than one word
            if (i - startIndex + 1 > 1) {
                attempt++;
            }

            if (attempt >= maxWidth) {
                // cannot add more.

                int end = i - 1;
                if (attempt == maxWidth) {
                    end = i;
                    runningLength = attempt;
                }

                if (runningLength == maxWidth) {

                    String[] pad = new String[end - startIndex];
                    Arrays.fill(pad, " ");

                    String buildResult = build(startIndex, end, words, pad);

                    result.add(buildResult);
                } else {
                    // need to pad whitespaces.
                    int extraNeeded = maxWidth - runningLength;

                    int wordCount = end - startIndex + 1;

                    // only one word.
                    if (wordCount == 1) {
                        String single = words[end] + generate(extraNeeded);
                        result.add(single);
                        startIndex = i;

                        runningLength = words[startIndex].length();

                        continue;

                    }

                    if (extraNeeded % (wordCount - 1) == 0) {

                        int averageExtra = extraNeeded / (wordCount - 1) + 1;

                        String empty = generate(averageExtra);

                        String[] pad = new String[end - startIndex];
                        Arrays.fill(pad, empty);

                        String buildResult = build(startIndex, end, words, pad);

                        result.add(buildResult);
                    } else {

                        int averageExtra = extraNeeded / (wordCount - 1);
                        int lastExtra = extraNeeded % (wordCount - 1);
                        String[] pad = new String[end - startIndex];

                        if (averageExtra > 0) {
                            String averagePad = generate(averageExtra + 1);
                            String extraPad = generate(lastExtra + 1);

                            Arrays.fill(pad, averagePad);
                            pad[pad.length - 1] = extraPad;
                        } else {
                            String averagePad = generate(2);
                            String extraPad = generate(1);

                            for (int k = 0; k < pad.length; k++) {

                                if (k <= lastExtra - 1) {
                                    pad[k] = averagePad;
                                } else {
                                    pad[k] = extraPad;
                                }

                            }

                        }

                        String buildResult = build(startIndex, end, words, pad);
                        result.add(buildResult);
                    }
                }

                startIndex = i;
                runningLength = words[startIndex].length();

                if (attempt == maxWidth) {
                    startIndex = i + 1;
                    runningLength = 0;
                }

            } else {
                runningLength = attempt;
            }

        }

        if (startIndex < words.length)

        {
            // handle last piece.
            StringBuilder sb = new StringBuilder();
            for (int i = startIndex; i < words.length; i++) {
                sb.append(words[i]);

                if (i != words.length - 1) {
                    sb.append(" ");
                }
            }

            if (sb.length() < maxWidth) {
                String pad = generate(maxWidth - sb.length());

                result.add(sb.toString() + pad);
            }
        }

        return result;
    }

    private String build(int start, int end, String[] words, String[] extraPad) {

        StringBuilder sb = new StringBuilder();
        for (int j = start; j <= end; j++) {
            sb.append(words[j]);

            if (j != end) {
                sb.append(extraPad[j - start]);
            }
        }

        return sb.toString();
    }

    private String generate(int length) {

        String empty = "";
        for (int p = 0; p < length; p++) {
            empty += " ";
        }

        return empty;

    }

    public static void main(String[] args) {
        TextJustification tj = new TextJustification();

        // String[] words = { "This", "is", "an", "example", "of", "text",
        // "justification." };

        String[] words = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a",
                "computer.", "Art", "is", "everything", "else", "we", "do" };
        int maxWidth = 20;

        List<String> result = tj.fullJustify(words, maxWidth);

        for (int i = 0; i < result.size(); i++) {

            System.out.println("@" + result.get(i) + "@\n");
        }
    }
}

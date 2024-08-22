package array.LongestCommonSuffixQueries;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSuffixQueriesV2 {
    class Node {
        Map<Character, Node> children = new HashMap<>();

        int index = -1;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        Node root = new Node();

        int indexOfShortest = 0;

        for (int i = 0; i < wordsContainer.length; i++) {
            String current = wordsContainer[i];

            if (current.length() < wordsContainer[indexOfShortest].length()) {
                indexOfShortest = i;
            }

            Node movingNode = root;

            for (int j = current.length() - 1; j >= 0; j--) {

                char currentChar = current.charAt(j);

                Node temp = movingNode.children.get(currentChar);

                if (temp == null) {
                    Node newNode = new Node();
                    newNode.index = i;

                    movingNode.children.put(currentChar, newNode);

                    movingNode = newNode;
                } else {
                    // already exists. Need to check source index.

                    if (wordsContainer[i].length() < wordsContainer[temp.index].length()) {
                        temp.index = i;
                    }

                    movingNode = temp;
                }

            }

        }

        int queryLength = wordsQuery.length;

        int[] result = new int[queryLength];

        for (int i = 0; i < queryLength; i++) {

            Node movingNode = root;

            String currentQuery = wordsQuery[i];

            int target = indexOfShortest;

            for (int j = currentQuery.length() - 1; j >= 0; j--) {
                char currentChar = currentQuery.charAt(j);

                Node temp = movingNode.children.get(currentChar);

                if (temp == null) {
                    break;
                } else {
                    target = temp.index;

                    movingNode = temp;
                }
            }

            result[i] = target;
        }

        return result;
    }

    public static void main(String[] args) {

        LongestCommonSuffixQueriesV2 ls = new LongestCommonSuffixQueriesV2();

        String[] container = { "abcd", "bcd", "xbcd" };
        String[] query = { "cd", "bcd", "xyz" };

        System.out.println(ls.stringIndices(container, query));
    }
}

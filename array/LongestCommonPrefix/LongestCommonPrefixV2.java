package array.LongestCommonPrefix;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefixV2 {

    class Node {
        Map<Character, Node> children = new HashMap<>();
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        Node root = new Node();

        // process int[] arr1
        for (int i = 0; i < arr1.length; i++) {

            String numString = Integer.toString(arr1[i]);
            Node movingNode = root;

            for (int j = 0; j < numString.length(); j++) {
                char currentChar = numString.charAt(j);
                movingNode = movingNode.children.computeIfAbsent(currentChar, key -> new Node());
            }
        }

        // process int[] arr2

        int longest = 0;

        for (int i = 0; i < arr2.length; i++) {
            String numString = Integer.toString(arr2[i]);

            Node movingNode = root;

            for (int j = 0; j < numString.length(); j++) {

                char currentChar = numString.charAt(j);

                movingNode = movingNode.children.get(currentChar);

                if (movingNode == null) {
                    break;
                }

                longest = Math.max(longest, j + 1);
            }
        }

        return longest;
    }

    public static void main(String[] args) {

        LongestCommonPrefixV2 lp = new LongestCommonPrefixV2();

        // int[] arr1 = { 1, 10, 100 };
        // int[] arr2 = { 1000 };

        int[] arr1 = { 1, 2, 3 };
        int[] arr2 = { 4, 4, 4 };

        System.out.println(lp.longestCommonPrefix(arr1, arr2));

        // System.out.println(Integer.toString(123));

    }
}

package CountPrefixAndSuffixPairs;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii/

public class CountPrefixAndSuffixPairsII {

    class CharPair {
        char left;
        char right;

        @Override
        public int hashCode() {
            return Character.hashCode(left) + Character.hashCode(right);
        }

        @Override
        public boolean equals(Object obj) {
            CharPair charPair = (CharPair) obj;
            return left == charPair.left && right == charPair.right;
        }
    }

    class Node {
        CharPair charPair;

        Map<CharPair, Node> children;

        int endedCount;
    }

    public long countPrefixSuffixPairs(String[] words) {

        Node root = new Node();

        long result = 0;

        for (int i = 0; i < words.length; i++) {

            long count = insert(words[i], root);

            result += count;
        }

        return result;
    }

    private long insert(String word, Node node) {

        Node movingNode = node;

        long count = 0;

        for (int i = 0; i < word.length(); i++) {
            int j = word.length() - 1 - i;

            CharPair pairToCheck = new CharPair();
            pairToCheck.left = word.charAt(i);
            pairToCheck.right = word.charAt(j);

            Map<CharPair, Node> children = movingNode.children;

            if (children == null) {
                children = new HashMap<>();

                movingNode.children = children;
            }

            if (children.containsKey(pairToCheck)) {
                // already added.
                movingNode = children.get(pairToCheck);

                count += movingNode.endedCount;
            } else {
                // need to add.
                Node newNode = new Node();
                newNode.charPair = pairToCheck;
                newNode.endedCount = 0;

                children.put(pairToCheck, newNode);

                movingNode = newNode;
            }

        }

        movingNode.endedCount++;

        return count;
    }

    public static void main(String[] args) {

        CountPrefixAndSuffixPairsII cp = new CountPrefixAndSuffixPairsII();

        // String[] words = { "a", "aba", "ababa", "aa" };

        // String[] words = { "pa", "papa", "ma", "mama" };

        // String[] words = { "abab", "ab" };

        String[] words = { "ab", "ab", "ab" };

        System.out.println(cp.countPrefixSuffixPairs(words));
    }

}

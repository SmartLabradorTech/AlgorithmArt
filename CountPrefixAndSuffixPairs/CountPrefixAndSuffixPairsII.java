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

        boolean hasEnd;
    }

    public long countPrefixSuffixPairs(String[] words) {

        Node root = new Node();

        for (int i = 0; i < words.length; i++) {

        }

        return 0;
    }

    private int insert(String word, Node node) {

        Node movingNode = node;

        int count = 0;

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

                if(){


                }
            } else {
                // need to add.
                Node newNode = new Node();
                newNode.charPair = pairToCheck;

                children.put(pairToCheck, newNode);

                movingNode = newNode;
            }

        }

    }

}

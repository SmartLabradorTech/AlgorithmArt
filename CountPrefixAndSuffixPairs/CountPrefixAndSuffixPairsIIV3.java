package CountPrefixAndSuffixPairs;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/count-prefix-and-suffix-pairs-ii/

// rewrite to use hashing to int.

public class CountPrefixAndSuffixPairsIIV3 {

    class Node {
        Map<Integer, Node> children = new HashMap<>();

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

            // the max value of `word.charAt(j) - 'a'` is 25 which is less than 32=2^5. Thus
            // as long as we shift by 5 bits, then it can ensure unique.
            int key = ((word.charAt(i) - 'a') << 5) + word.charAt(j) - 'a';

            Map<Integer, Node> children = movingNode.children;

            // computeIfAbsent is more efficient to handle absent case.
            movingNode = children.computeIfAbsent(key, keyValue -> {
                return new Node();
            });

            count += movingNode.endedCount;
        }

        movingNode.endedCount++;

        return count;
    }

    public static void main(String[] args) {

        CountPrefixAndSuffixPairsII cp = new CountPrefixAndSuffixPairsII();

        // String[] words = { "a", "aba", "ababa", "aa" };

        // String[] words = { "pa", "papa", "ma", "mama" };

        // String[] words = { "abab", "ab" };

        // String[] words = { "ab", "ab", "ab" };

        String[] words = { "a", "aa", "aa", "b", "ab" };

        System.out.println(cp.countPrefixSuffixPairs(words));
    }

}

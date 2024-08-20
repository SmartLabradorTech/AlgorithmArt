package CountPrefixAndSuffixPairs;

import java.util.HashMap;
import java.util.Map;

// This is the official answer for learning purpose.

public class CountPrefixAndSuffixPairsIIV2 {
    class Node {
        Map<Integer, Node> son = new HashMap<>();
        int cnt;
    }

    public long countPrefixSuffixPairs(String[] words) {
        long ans = 0;
        Node root = new Node();
        for (String S : words) {
            char[] s = S.toCharArray();
            int n = s.length;
            Node cur = root;
            for (int i = 0; i < n; i++) {
                int p = (s[i] - 'a') << 5 | (s[n - 1 - i] - 'a');
                cur = cur.son.computeIfAbsent(p, k -> new Node());
                ans += cur.cnt;
            }
            cur.cnt++;
        }
        return ans;
    }

    public static void main(String[] args) {

        CountPrefixAndSuffixPairsIIV2 cp = new CountPrefixAndSuffixPairsIIV2();

        // String[] words = { "a", "aba", "ababa", "aa" };

        // String[] words = { "pa", "papa", "ma", "mama" };

        // String[] words = { "abab", "ab" };

        String[] words = { "ab", "ab", "ab" };

        System.out.println(cp.countPrefixSuffixPairs(words));
    }
}

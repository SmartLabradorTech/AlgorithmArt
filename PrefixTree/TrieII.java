package PrefixTree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/implement-trie-ii-prefix-tree/description/
public class TrieII {
    class Node {
        char character;
        int count;
        Map<Character, Node> children;
    }

    Node root;

    public TrieII() {
        root = new Node();
    }

    public void insert(String word) {

        insert(root, word, 0);
    }

    private void insert(Node node, String word, int index) {

        if (index > word.length()) {
            return;
        }

        Map<Character, Node> currentChildren = node.children;

        if (currentChildren == null) {
            Map<Character, Node> newChildren = new HashMap<>();

            node.children = newChildren;

            currentChildren = newChildren;
        }

        char targetChar = '/';

        if (index < word.length()) {
            targetChar = word.charAt(index);
        }

        if (currentChildren.containsKey(targetChar)) {
            // the char is already there.
            currentChildren.get(targetChar).count++;

            insert(currentChildren.get(targetChar), word, index + 1);
        } else {

            Node newNode = new Node();
            newNode.character = targetChar;
            newNode.count = 1;

            currentChildren.put(targetChar, newNode);

            insert(newNode, word, index + 1);
        }

    }

    public int countWordsEqualTo(String word) {
        Node node = root;

        for (int i = 0; i <= word.length(); i++) {
            Map<Character, Node> currentChildren = node.children;

            if (currentChildren == null) {
                return 0;
            }

            char charToSearch = '/';

            if (i < word.length()) {
                charToSearch = word.charAt(i);
            }

            if (currentChildren.containsKey(charToSearch)) {
                node = currentChildren.get(charToSearch);
            } else {
                return 0;
            }
        }

        return node.count;
    }

    public int countWordsStartingWith(String prefix) {
        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {
            Map<Character, Node> currentChildren = node.children;

            if (currentChildren == null) {
                return 0;
            }

            char charToSearch = prefix.charAt(i);

            if (currentChildren.containsKey(charToSearch)) {
                node = currentChildren.get(charToSearch);
            } else {
                return 0;
            }
        }

        return node.count;
    }

    public void erase(String word) {
        Node node = root;

        for (int i = 0; i <= word.length(); i++) {

            Map<Character, Node> currentChildren = node.children;

            if (currentChildren == null) {
                return;
            }

            char charToDelete = '/';

            if (i < word.length()) {
                charToDelete = word.charAt(i);
            }

            Node currentNode = currentChildren.get(charToDelete);

            if (currentNode == null) {
                return;
            }

            if (currentNode.count == 1) {
                currentChildren.remove(charToDelete);
            } else {
                currentNode.count--;
            }

            node = currentNode;
        }
    }

    public static void main(String[] args) {

        TrieII trie = new TrieII();

        trie.insert("apple"); // Inserts "apple".
        trie.insert("apple"); // Inserts another "apple".

        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("app")); // "app" is a prefix of "apple" so return 2.
        trie.erase("apple"); // Erases one "apple".
        System.out.println(trie.countWordsEqualTo("apple")); // Now there is only one instance of "apple" so return 1.
        System.out.println(trie.countWordsStartingWith("app")); // return 1
        trie.erase("apple"); // Erases "apple". Now the trie is empty.
        System.out.println(trie.countWordsStartingWith("app")); // return 0

    }

}

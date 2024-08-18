package PrefixTree;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/implement-trie-prefix-tree/description/

class Trie {

    class Node {
        char character;
        Map<Character, Node> children;
    }

    Node root;

    public Trie() {
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

            insert(currentChildren.get(targetChar), word, index + 1);
        } else {

            Node newNode = new Node();
            newNode.character = targetChar;

            currentChildren.put(targetChar, newNode);

            insert(newNode, word, index + 1);
        }

    }

    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {

        if (index > word.length()) {
            return node.children == null;
        }

        Map<Character, Node> currentChildren = node.children;

        if (currentChildren == null) {
            return false;
        }

        char targetChar = '/';

        if (index < word.length()) {
            targetChar = word.charAt(index);
        }

        if (currentChildren.containsKey(targetChar)) {
            return search(currentChildren.get(targetChar), word, index + 1);
        } else {
            return false;
        }
    }

    public boolean startsWith(String prefix) {

        return startsWith(root, prefix, 0);

    }

    private boolean startsWith(Node node, String prefix, int index) {

        if (index >= prefix.length()) {
            return true;
        }

        Map<Character, Node> currentChildren = node.children;

        if (currentChildren == null) {
            return false;
        }

        char targetChar = prefix.charAt(index);

        if (currentChildren.containsKey(targetChar)) {
            return startsWith(currentChildren.get(targetChar), prefix, index + 1);
        }

        return false;

    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");

        System.out.println(trie.search("apple"));

        System.out.println(trie.search("app"));

        System.out.println(trie.startsWith("app"));

        trie.insert("app");

        System.out.println(trie.search("app"));

    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

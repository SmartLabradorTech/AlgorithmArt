package PrefixTree.AddAndSearchWords;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/description/

public class WordDictionary {

    class Node {
        char character;
        Map<Character, Node> children;
    }

    Node root;

    public WordDictionary() {

        root = new Node();
    }

    public void addWord(String word) {
        Node node = root;

        for (int i = 0; i <= word.length(); i++) {
            Map<Character, Node> currentChildren = node.children;

            char currentChar = '/';

            if (i < word.length()) {
                currentChar = word.charAt(i);
            }

            if (currentChildren == null) {
                currentChildren = new HashMap<>();
                node.children = currentChildren;
            }

            if (currentChildren.containsKey(currentChar)) {
                // already added.
            } else {

                Node newNode = new Node();
                newNode.character = currentChar;

                currentChildren.put(currentChar, newNode);
            }

            node = currentChildren.get(currentChar);
        }

    }

    public boolean search(String word) {

        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (index > word.length()) {
            return true;
        }

        char chatToSearch = '/';

        if (index < word.length()) {
            chatToSearch = word.charAt(index);
        }

        Map<Character, Node> currentChildren = node.children;

        if (currentChildren == null) {
            return false;
        }

        if (chatToSearch == '.') {
            for (Character eachCharacter : currentChildren.keySet()) {

                if (eachCharacter != '/' && search(currentChildren.get(eachCharacter), word, index + 1)) {
                    return true;
                }
            }

        } else {
            if (currentChildren.containsKey(chatToSearch)) {
                return search(currentChildren.get(chatToSearch), word, index + 1);
            } else {
                return false;
            }

        }

        return false;
    }

    public static void main(String[] args) {

        WordDictionary wordDictionary = new WordDictionary();

        // System.out.println();

        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad"));
        System.out.println(wordDictionary.search("bad"));
        System.out.println(wordDictionary.search(".ad"));
        System.out.println(wordDictionary.search("b.."));

        ; // return False
        ; // return True
        ; // return True
        ; // return True

    }

}

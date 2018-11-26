package com.ywt.trie.problem211;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: YwT
 * @create: 2018-11-26 16:54
 **/
public class WordDictionary {

    private class Node {
        boolean isWord;
        Map<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        char[] cs = word.toCharArray();
        for (char c  : cs) {
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord){
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    public boolean match(Node node, String word, int index){
        if (index == word.length()){
            return node.isWord;
        }
        char c = word.charAt(index);
        if (c != '.'){
            if (node.next.get(c) == null){
                return false;
            }
            return match(node.next.get(c), word, ++index);
        }else {
            for (Character nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, ++index)){
                    return true;
                }
            }
            return false;
        }
    }
}

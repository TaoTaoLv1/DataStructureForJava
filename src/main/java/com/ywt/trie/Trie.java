package com.ywt.trie;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: YwT
 * @description: 字典树，Trie树
 * @create: 2018-11-26 15:22
 **/
public class Trie {
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

    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 添加一个单词
     * @param word
     */
    public void add(String word){
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
            size ++;
        }
    }

    /**
     * 查询是否存在这个单词
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur = root;
        char[] cs = word.toCharArray();
        for (char c  : cs) {
            if (cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }
}

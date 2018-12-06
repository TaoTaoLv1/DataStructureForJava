package com.ywt.trie;

import java.util.ArrayList;
import java.util.List;
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
        Node node = find(word);
        return  node== null ? false: node.isWord;
    }

    public boolean isPrefix(String prefix){
        return find(prefix) == null ? false : true;
    }

    private Node find(String s){
        Node cur = root;
        char[] cs = s.toCharArray();
        for (char c  : cs) {
            if (cur.next.get(c) == null){
                return null;
            }
            cur = cur.next.get(c);
        }

        return cur;
    }

    public void preOrder(){
        preOrder(root, 0);
    }

    //前序遍历
    private void preOrder(Node node, int layer){
        for (Character c : node.next.keySet()){
            for (int i = 0; i < layer; i++){
                System.out.print("-");
            }
            System.out.print(c);
            if (node.next.get(c).isWord){
                System.out.print("(end)");
            }
            System.out.println();
            preOrder(node.next.get(c), layer + 1);
        }
    }

    public void  deepOrder(){
        StringBuilder word = new StringBuilder();
        List<String> words = new ArrayList<>();
        deepOrder(root, word, words);
        for (String w : words) {
            System.out.println(w);
        }
    }

    private void deepOrder(Node node, StringBuilder word, List<String> words){
        for (Character c : node.next.keySet()) {
            word.append(c);
            if (node.next.get(c).isWord){
                words.add(word.toString());
            }
            deepOrder(node.next.get(c), word, words);
            word.deleteCharAt(word.length() - 1);
        }
    }
}

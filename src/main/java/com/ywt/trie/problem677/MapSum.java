package com.ywt.trie.problem677;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author: YwT
 * @create: 2018-11-26 21:00
 **/
public class MapSum {

    private class Node {

        private int value;
        Map<Character, Node> next;

        public Node(int value) {
            this.value = value;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String word, int val) {
        Node cur = root;
        char[] cs = word.toCharArray();
        for (char c  : cs) {
            if (cur.next.get(c) == null){
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        Node cur = root;
        char[] cs = prefix.toCharArray();
        for (char c  : cs) {
            if (cur.next.get(c) == null){
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node){
        int res = node.value;
        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }
}
/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */

package com.ywt.BinarySearchTree;

/**
 * @author: YwT
 * @description: 二分搜索树实现
 * @create: 2018-11-13 12:42
 **/
public class BST<T extends Comparable<T>>{

    private class Node{
        private T e;
        private Node left, right;

        public Node(T e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(T e){
        if (root == null){
            root = new Node(e);
        }else {
            add(root, e);
        }
    }

    private void add(Node node, T e){
        if (e.equals(node.e)){
            return;
        }else if (e.compareTo(node.e) < 0){
            if (node.left == null){
                node.left = new Node(e);
                size ++;
                return;
            }else {
                add(node.left, e);
            }
        }else if (e.compareTo(node.e) > 0){
            if (node.right == null){
                node.right = new Node(e);
                size ++;
                return;
            }else {
                add(node.right, e);
            }
        }
    }
}

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
         root = add(root, e);
    }

    private Node add(Node node, T e){
        if (node == null){
            size ++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if (e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(T e){
        return contains(root, e);
    }

    public boolean contains(Node node, T e){
        if (root == null){
            return false;
        }
        if (e.compareTo(node.e) == 0){
            return true;
        }else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else {
            return contains(node.right, e);
        }
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node == null){
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以 node 为根节点，深度为 depth 的描述二叉树的字符串
     * @param node
     * @param depth
     * @param res
     */
    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.e).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    /**
     * 返回树的深度
     * @param depth
     * @return
     */
    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++){
            res.append("--");
        }
        return res.toString();
    }
}

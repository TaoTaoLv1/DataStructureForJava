package com.ywt.AVLTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: YwT
 * @description: AVL树（平衡二叉树）
 * @create: 2018-11-27 10:42
 **/
public class AVLTree<K extends Comparable<K>, V>{

    private class Node{
        K key;
        V value;
        Node left, right;
        int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.right = null;
            this.left = null;
            this.height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 向二分搜索树递归添加元素
     * @param node
     * @param key
     * @param value
     * @return
     */
    public Node add(Node node, K key, V value){
        if (node == null){
            size ++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if (key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }else {
            node.value = value;
        }
        //更新树的高度
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1){
            //TODO
        }
        return node;
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){
        Node successor = null;
        if (node == null){
            return null;
        }

        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
        }else {
            //待删除节点左子树为空的情况
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除节点右子树为空的情况
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //待删除节点左右子树都不为空的情况
            //找到比待删除节点大的最小节点；即 待删除节点 的 右子树最小的节点
            successor = minnum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
        }
        return successor;
    }

    private Node removeMin(Node node){
        if (node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node minnum(Node node){
        if (node.left == null){
            return node;
        }
        return minnum(node.left);
    }


    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null){
            throw new IllegalArgumentException("key 不存在");
        }

        node.value = newValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断是否是一颗二分搜树
     * @param node
     * @return
     */
    public boolean isBST(Node node){
        List<K> keys = new ArrayList<>();
        inOrder(node, keys);
        for (int i = 1; i < keys.size(); i++){
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0){
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }

    /**
     * 判断是否是一颗平衡二叉树
     * @param node
     * @return
     */
    private boolean isBalanced(Node node){
        if (node == null){
            return true;
        }
        if (getBalanceFactor(node) > 1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * 二叉树 中序遍历
     * @param node
     * @param keys
     */
    private void inOrder(Node node, List<K> keys){
        if (node == null){
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    private Node getNode(Node node, K key){
        if (node == null){
            return null;
        }

        if (key.compareTo(node.key) == 0){
            return node;
        }else if (key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else {
            return getNode(node.right, key);
        }
    }

    /**
     * 获取树的高度
     * @param node 树节点
     * @return     高度
     */
    private int getHeight(Node node){
        if (node == null){
            return 0;
        }
        return node.height;
    }

    /**
     * 获取节点node 的平衡因子
     * @param node 节点
     * @return      平衡因子
     */
    private int getBalanceFactor(Node node){
        if (node == null){
            return 0;
        }
        return Math.abs(getHeight(node.left) - getHeight(node.right));
    }
}

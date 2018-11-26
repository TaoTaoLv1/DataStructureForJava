package com.ywt.segmenttree;

import java.util.Arrays;

/**
 * @author: YwT
 * @description: 线段树实现
 * @create: 2018-11-22 14:44
 **/
public class SegmentTree<T> {

    private T[] tree;
    private T[] data;
    private Merger<T> merger;

    public SegmentTree(T[] arr, Merger<T> merger) {
        this.merger = merger;
        data = Arrays.copyOf(arr, arr.length);
        tree = (T[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 位置的创建 表示[leftIndex....rightIndex] 的区间树
     * @param treeIndex   区间树位置下标
     * @param leftIndex 数组的左边界
     * @param rightIndex 数组的有边界
     */
    private void buildSegmentTree(int treeIndex, int leftIndex, int rightIndex){
        if (leftIndex == rightIndex){
            tree[treeIndex] = data[leftIndex];
            return;
        }

        int mid = leftIndex + (rightIndex - leftIndex) / 2;
        int leftChildTree = leftChild(treeIndex);
        int rightChildTree = rightChild(treeIndex);

        buildSegmentTree(leftChildTree, leftIndex, mid);
        buildSegmentTree(rightChildTree, mid + 1, rightIndex);

        tree[treeIndex] = merger.merge(tree[leftChildTree], tree[rightChildTree]);
    }

    public int getSize(){
        return data.length;
    }

    public T get(int index){
        if (index < 0 ||index > data.length){
            throw  new IllegalArgumentException("下标越界");
        }
        return data[index];
    }

    /**
     * 返回当前节点的 左孩子索引
     * @param index
     * @return
     */
    private int leftChild(int index){
        return index * 2 + 1;
    }

    /**
     * 返回当前节点的 右孩子索引
     * @param index
     * @return
     */
    private int rightChild(int index){
        return index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for(int i = 0 ; i < tree.length ; i ++){
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if(i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}

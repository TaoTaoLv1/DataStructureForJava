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
     * @param rightIndex 数组的右边界
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
     * @param queryL  数组左边界
     * @param queryR  数组右边界
     * @return  返回【L....R】的值
     */
    public T query(int queryL, int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("索引超标");
        return query(0, 0, data.length -1, queryL, queryR);
    }

    /**
     *
     * @param treeIndex  线段树的根
     * @param l           线段树的左边界
     * @param r           线段树的右边界
     * @param queryL     待查询的左边界
     * @param queryR     待查询的右边界
     * @return
     */
    private T query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftChildTree = leftChild(treeIndex);
        int rightChildTree = rightChild(treeIndex);

        if (queryL >= mid + 1){
            return query(rightChildTree, mid + 1, r, queryL, queryR);
        }else if (queryR <= mid){
            return query(leftChildTree, l, mid, queryL, queryR);
        }

        T leftResult = query(leftChildTree, l, mid, queryL, mid);
        T rightResult = query(rightChildTree, mid + 1, r, mid + 1, queryR);

        return merger.merge(leftResult, rightResult);
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

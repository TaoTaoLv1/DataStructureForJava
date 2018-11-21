package com.ywt.maxheap;

import com.ywt.array.Array;

/**
 * @author: YwT
 * @description: 最大二叉堆（最大堆）
 * @create: 2018-11-21 11:10
 **/
public class MaxHeap<T extends Comparable<T>>  {

    private Array<T> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(T[] arr){
        data = new Array<>(arr);
        for (int i = parentIndex(arr.length - 1); i >= 0; i --){
            siftDown(i);
        }
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void add(T e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index){
        while (index > 0 && data.get(parentIndex(index)).compareTo(data.get(index)) < 0){
            data.swap(index, parentIndex(index));
        }
    }

    /**
     * 查看堆中最大元素
     * @return
     */
    public T findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("堆为空");
        }
        return data.get(0);
    }

    /**
     * 推出堆中最大元素
     * @return
     */
    public T extractMax(){
        T ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    /**
     * 重新排序堆
     * @param index
     */
    private void siftDown(int index){
        while (leftChild(index) < data.getSize()){
            int maxChild = leftChild(index);
            //找出 最大的 左右孩子
            if (maxChild + 1 < data.getSize() && data.get(maxChild + 1).compareTo(data.get(maxChild)) > 0){
                maxChild ++;
                //maxChild = rightChild(index);
            }
            if (data.get(index).compareTo(data.get(maxChild)) > 0){
                break;
            }

            data.swap(index, maxChild);
            index = maxChild;
        }
    }

    /**
     * 把 堆顶元素 替换成 e
     * @param e
     * @return
     */
    public T replace(T e){
        T ret = findMax();
        data.set(0,e);
        siftDown(0);
        return ret;
    }

    /**
     * 返回当前节点的 父节点
     * @param index
     * @return
     */
    private int parentIndex(int index){
        if (index == 0)
            throw new IllegalArgumentException("0 没有父节点");
        return (index - 1) / 2;
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

}

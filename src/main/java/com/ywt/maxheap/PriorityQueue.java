package com.ywt.maxheap;

import com.ywt.queue.Queue;

/**
 * @author: YwT
 * @create: 2018-11-21 18:21
 **/
public class PriorityQueue<T extends Comparable<T>> implements Queue<T> {

    private MaxHeap<T> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(T e) {
        maxHeap.add(e);
    }

    @Override
    public T dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public T getFront() {
        return maxHeap.findMax();
    }
}

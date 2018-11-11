package com.ywt.queue;

/**
 * @description: 队列实现
 * @author: YwT
 * @create: 2018-10-16 15:27
 **/
public interface Queue<T> {

    int getSize();

    boolean isEmpty();

    void enqueue(T e);

    T dequeue();

    T getFront();
}

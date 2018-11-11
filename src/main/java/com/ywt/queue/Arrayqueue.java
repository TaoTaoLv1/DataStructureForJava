package com.ywt.queue;

import com.ywt.array.Array;

/**
 * @description: 队列
 * @author: YwT
 * @create: 2018-10-16 15:30
 **/
public class Arrayqueue<T> implements Queue<T> {

    private Array<T> array;

    public Arrayqueue(int capacity) {
        array = new Array<>(capacity);
    }

    public Arrayqueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(T e) {
        array.addLast(e);
    }

    @Override
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for(int i = 0; i < array.getSize(); i++){
            res.append(array.get(i));
            if (i != array.getSize() - 1){
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        Arrayqueue<Integer> arrayqueue = new Arrayqueue<>();

        for (int i = 0; i < 10; i++){
            arrayqueue.enqueue(i);
            System.out.println(arrayqueue);

            if (i % 3 == 2){
                arrayqueue.dequeue();
                System.out.println(arrayqueue);
            }
        }
    }
}

package com.ywt.set;

import com.ywt.linkedlist.LinkedList;

/**
 * @author: YwT
 * @description: 以链表实现集合
 * @create: 2018-11-19 14:30
 **/
public class LinkedListSet<T> implements Set<T> {

    private LinkedList<T> list;

    public LinkedListSet() {
        list = new LinkedList<>();
    }

    @Override
    public void add(T e) {
        if (!list.contains(e)){
            list.addFirst(e);
        }
    }

    @Override
    public void remove(T e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(T e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}

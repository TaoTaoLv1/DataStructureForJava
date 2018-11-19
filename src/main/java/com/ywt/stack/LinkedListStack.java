package com.ywt.stack;

import com.ywt.linkedlist.LinkedList;


/**
 * @description: 链表实现栈
 * @author: YwT
 * @create: 2018-10-23 18:23
 **/
public class LinkedListStack<T> implements Stack<T> {

    private LinkedList<T> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(T e){
        list.addFirst(e);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek(){
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack：top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args){
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}

package com.ywt.stack;

public interface Stack<T> {

    int getSize();
    boolean isEmpty();
    void push(T e) throws IllegalAccessException;
    T pop() throws IllegalAccessException;
    T peek() throws IllegalAccessException;
}

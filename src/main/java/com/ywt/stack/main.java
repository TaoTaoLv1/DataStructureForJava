package com.ywt.stack;

import com.ywt.linelist.LinkedList;

/**
 * @description:
 * @author: YwT
 * @create: 2018-10-15 20:59
 **/
public class main {

    public static void main(String[] args) throws IllegalAccessException {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++){
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}

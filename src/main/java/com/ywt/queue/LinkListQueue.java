package com.ywt.queue;

/**
 * @author: YwT
 * @description 链表 实现 队列 数据结构
 * @create: 2018-10-30 16:59
 **/
public class LinkListQueue<T> implements Queue<T> {

    /**
     * Node 节点
     */
    private class Node{
        public T t;
        public Node next; //指向下一个节点

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t){
            this(t, null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }

    private Node head, tail;
    private int size;

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(T e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }

        size ++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            throw new IllegalArgumentException("空队列");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null){
            tail = null;
        }
        size --;
        return retNode.t;
    }

    @Override
    public T getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException("空队列");
        }
        return head.t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while (cur != null){
            res.append(cur + " -> ");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkListQueue<Integer> arrayqueue = new LinkListQueue<>();

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

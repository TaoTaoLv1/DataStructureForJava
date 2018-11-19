package com.ywt.linkedlist;

/**
 * @description: 链表
 * @author: YwT
 * @create: 2018-10-19 15:29
 **/
public class LinkedList<T> {

    private class Node{
        public T t;
        public Node next;

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

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void add(int index, T t){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("index 参数不对");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

//            Node node = new Node(t);
//            node.next = prev.next;
//            prev.next = node;

        prev.next = new Node(t, prev.next);
        size ++;

    }

    public void addLast(T t){
        add(size, t);
    }

    public void addFirst(T t){
        add(0, t);
    }

    public T get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("index 参数不对");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }

        return cur.t;
    }

    public T getFirst(){
        return get(0);
    }

    public T getLast(){
        return get(size - 1);
    }

    public void set(int index, T t){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index 参数不对");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++){
            cur = cur.next;
        }
        cur.t = t;
    }

    public boolean contains(T t){
        Node cur = dummyHead.next;
        while (cur != null){
            if (cur.t.equals(t)){
                return true;
            }
        }
        return false;
    }

    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("index 参数不对");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size --;
        return retNode.t;

    }

    public T removeFirst(){
        return remove(0);
    }

    public T removeLast(){
        return remove(size - 1);
    }

    // 从链表中删除元素e
    public void removeElement(T e){

        Node prev = dummyHead;
        while(prev.next != null){
            if(prev.next.t.equals(e))
                break;
            prev = prev.next;
        }

        if(prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size --;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null){
            res.append(cur + "->" );
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}

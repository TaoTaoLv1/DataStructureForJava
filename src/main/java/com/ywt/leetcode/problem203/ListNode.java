package com.ywt.leetcode.problem203;

/**
 * @author: YwT
 * @create: 2018-10-30 20:36
 **/
public class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int[] arr) {
        val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            res.append(cur.val + "->");
            cur = cur.next;
        }
        res.append("null");
        return res.toString();
    }
}

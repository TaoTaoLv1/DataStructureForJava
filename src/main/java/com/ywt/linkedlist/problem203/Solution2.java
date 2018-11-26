package com.ywt.linkedlist.problem203;

/**
 * @author: YwT
 * @create: 2018-10-30 20:52
 **/
public class Solution2 {
    public ListNode removeElements(ListNode head, int val){

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;
        while (prev.next != null){
            if (prev.next.val == val){
                prev.next = prev.next.next;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }
}

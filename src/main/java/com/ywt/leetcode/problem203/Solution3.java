package com.ywt.leetcode.problem203;

/**
 * @author: YwT
 * @description: 递归解决LeetCode 203号
 *
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @create: 2018-11-01 20:22
 **/
public class Solution3 {
    public static ListNode removeElements(ListNode head, int val){
        if (head == null){
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 6, 3, 4, 5, 6, 7};
        ListNode listNode = new ListNode(a);
        System.out.println(listNode);
        System.out.println(removeElements(listNode, 6));
    }
}

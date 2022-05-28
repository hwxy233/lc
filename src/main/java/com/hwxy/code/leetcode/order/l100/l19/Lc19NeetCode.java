package com.hwxy.code.leetcode.order.l100.l19;

import com.hwxy.code.ds.ListNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/28
 **/
public class Lc19NeetCode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        // 双指针间隔n个节点顺着走即可,创建一个虚拟节点方便移动
        ListNode newHead = new ListNode();
        newHead.next = head;
        ListNode left = newHead;
        ListNode right = newHead;
        for (int i = 0; i < n; i++) {
            right = right.next;
        }
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        // left.next是要删除的
        left.next = left.next.next;
        return newHead.next;
    }
}

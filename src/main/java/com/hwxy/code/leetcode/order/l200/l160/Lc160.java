package com.hwxy.code.leetcode.order.l200.l160;

import com.hwxy.code.ds.ListNode;

/**
 * 160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * 
 * @author hwxy
 * @date 2022/07/29
 **/
public class Lc160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        // 让2个p同时走相同的步长
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}

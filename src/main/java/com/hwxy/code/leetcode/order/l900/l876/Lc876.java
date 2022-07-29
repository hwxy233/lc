package com.hwxy.code.leetcode.order.l900.l876;

import com.hwxy.code.ds.ListNode;

/**
 * 876. 链表的中间结点
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * 
 * @author hwxy
 * @date 2022/07/29
 **/
public class Lc876 {

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // p1一次走一步,p2一次走2步,这样就相当于是p2走到尾(null)时p1恰好在中间(偶数就是后一个节点)
        ListNode p1 = dummy;
        ListNode p2 = dummy;
        while (p2 != null) {
            p1 = p1.next;
            for (int i = 0; p2 != null && i < 2; i++) {
                p2 = p2.next;
            }
        }
        return p1;
    }
}

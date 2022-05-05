package com.hwxy.code.leetcode.order.l300.l203;

import com.hwxy.ds.ListNode;

/**
 * 203. 移除链表元素
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 虚拟节点,最后返回他的next
        ListNode virtualNode = new ListNode();
        virtualNode.next = head;
        ListNode cur = virtualNode;
        // cur -> cur.next -> cur.next.next
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                // 如果不是才后移,否则要重新检测
                cur = cur.next;
            }
        }
        return virtualNode.next;
    }
}

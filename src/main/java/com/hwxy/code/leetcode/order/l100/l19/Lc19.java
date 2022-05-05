package com.hwxy.code.leetcode.order.l100.l19;

import com.hwxy.index.leetcode.everyday.linkedlist.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode virtualNode = new ListNode();
        virtualNode.next = head;
        ListNode slow = virtualNode;
        ListNode fast = virtualNode;
        // 双指针法,让fast先移动n+1个,方便删除
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return virtualNode.next;
    }
}

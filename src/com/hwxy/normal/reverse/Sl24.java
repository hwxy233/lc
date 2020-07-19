package com.hwxy.normal.reverse;

import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * * <p>
 * * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * * <p>
 * * 示例:
 * * <p>
 * * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Sl24 {
    /**
     * Definition for singly-linked list.
     */
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        // 先交换一次拿到新的head
        ListNode next = head.next;
        ListNode tmp = next.next;
        next.next = head;
        head.next = tmp;
        swap(tmp, head);
        return next;
    }

    public void swap(ListNode head, ListNode pre) {
        // 还能不能交换
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return;
        }
        ListNode next = head.next;
        ListNode tmp = next.next;
        next.next = head;
        head.next = tmp;
        // 记得交换后把新的head当做上一个节点的next
        pre.next = next;
        swap(tmp, head);
    }
}

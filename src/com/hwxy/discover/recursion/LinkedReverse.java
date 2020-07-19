package com.hwxy.discover.recursion;

import java.util.Objects;

/**
 * https://leetcode-cn.com/explore/featured/card/recursion-i/256/principle-of-recursion/1200/
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class LinkedReverse {
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

    public static void main(String[] args) {
        LinkedReverse linkedReverse = new LinkedReverse();
        ListNode f = new ListNode(1);
        ListNode c = f;
        for (int i = 1; i < 4; i++) {
            ListNode l = new ListNode(i + 1);
            c.next = l;
            c = l;
        }
        ListNode sw = linkedReverse.swapPairs(f);
        while (Objects.nonNull(sw)) {
            System.out.println(sw.val);
            sw = sw.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        ListNode next = head.next;
        ListNode tmp = next.next;
        next.next = head;
        head.next = tmp;
        swap(tmp, head);
        return next;
    }

    public void swap(ListNode head, ListNode pre) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return;
        }
        ListNode next = head.next;
        ListNode tmp = next.next;
        next.next = head;
        head.next = tmp;
        pre.next = next;
        swap(tmp, head);
    }
}
package com.hwxy.order.l6100.lc6013;

/**
 * 周赛
 * 6013. 合并零之间的节点
 *https://leetcode-cn.com/problems/merge-nodes-in-between-zeros/
 * @author hwxy
 * @date 2022/02/20
 **/
public class Lc6013 {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(1);
        node.next = node1;
        node1.next = node2;
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(0);
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        new Lc6013().mergeNodes(node);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeNodes(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode newHead = head;
        ListNode cur = newHead.next;
        int sum = 0;
        while (cur != null) {
            sum += cur.val;
            // 找到了一对?
            if (cur.next != null && cur.next.val == 0) {
                // 新节点
                ListNode newNode = new ListNode(sum);
                // 新头的next是新节点
                newHead.next = newNode;
                // 新节点变成了新头
                newHead = newNode;
                sum = 0;
            }
            // cur后移
            cur = cur.next;
        }
        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

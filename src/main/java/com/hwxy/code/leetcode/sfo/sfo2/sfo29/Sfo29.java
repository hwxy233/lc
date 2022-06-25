package com.hwxy.code.leetcode.sfo.sfo2.sfo29;

/**
 * 剑指 Offer II 029. 排序的循环链表
 * https://leetcode.cn/problems/4ueAj6/
 * 
 * @author hwxy
 * @date 2022/06/18
 **/
public class Sfo29 {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }
        if (head == head.next) {
            head.next = node;
            node.next = head;
            return head;
        }
        Node cur = head;
        Node next = head.next;
        do {
            // 正常位置
            if ((insertVal >= cur.val && insertVal <= next.val)) {
                break;
            } else if (cur.val > next.val) {
                // 最大/小后面,[3,4,1]插5
                if (insertVal > cur.val || insertVal < next.val) {
                    break;
                }
            }
            cur = cur.next;
            next = next.next;
        } while (cur != head);
        // 全相等随便插
        cur.next = node;
        node.next = next;
        return head;
    }

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }
}

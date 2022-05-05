package com.hwxy.code.leetcode.order.l300.l206;

import com.hwxy.code.ds.ListNode;

/**
 * 206. 反转链表
 * https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc206 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        System.out.println(new Lc206().reverseList(l1));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        // 注意pre先初始化成null
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}

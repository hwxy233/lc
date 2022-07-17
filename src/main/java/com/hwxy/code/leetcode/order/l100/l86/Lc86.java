package com.hwxy.code.leetcode.order.l100.l86;

import java.util.Arrays;
import java.util.List;

import com.hwxy.code.ds.ListNode;

/**
 * 86. 分隔链表
 * https://leetcode.cn/problems/partition-list/
 * 
 * @author hwxy
 * @date 2022/07/16
 **/
public class Lc86 {

    public static void main(String[] args) {
        ListNode root = new ListNode(-1);
        List<Integer> list = Arrays.asList(1, 4, 3, 2, 5, 2);
        ListNode p = root;
        for (int i : list) {
            p.next = new ListNode(i);
            p = p.next;
        }
        System.out.println(new Lc86().partition(root.next, 3));
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        // 烧饼
        ListNode largerDummy = new ListNode(-1);
        ListNode smallerDummy = new ListNode(-1);
        ListNode p = largerDummy;
        ListNode q = smallerDummy;
        // 对head要断开后面的next
        while (head != null) {
            if (x > head.val) {
                // 小的
                q.next = head;
                q = q.next;
            } else {
                // 大的
                p.next = head;
                p = p.next;
            }
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        q.next = largerDummy.next;
        return smallerDummy.next;
    }
}

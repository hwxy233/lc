package com.hwxy.code.leetcode.order.l100.l23;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.hwxy.code.ds.ListNode;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 
 * @author hwxy
 * @date 2022/07/17
 **/
public class Lc23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode == null) {
                continue;
            }
            queue.offer(listNode);
        }
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!queue.isEmpty()) {
            ListNode min = queue.poll();
            p.next = min;
            p = p.next;
            if (min.next != null) {
                queue.offer(min.next);
            }
        }
        return dummy.next;
    }
}

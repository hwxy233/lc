package com.hwxy.code.leetcode.order.l100.l23;

import java.util.Comparator;
import java.util.PriorityQueue;

import com.hwxy.code.ds.ListNode;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 优先级队列
 *
 * @author hwxy
 * @date 2022/06/25
 **/
public class Lc23Dong {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue =
                new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                queue.add(listNode);
            }
        }
        // 每次add后将当前的后一个节点放到queue这样下次就是最小的了
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode next = queue.poll();
            cur.next = next;
            // 这样保证下一个也是最小的
            if (next.next != null) {
                queue.add(next.next);
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}

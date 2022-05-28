package com.hwxy.code.leetcode.order.l100.l23;

import com.hwxy.code.ds.ListNode;

/**
 * 23. 合并K个升序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 * 
 * @author hwxy
 * @date 2022/05/28
 **/
public class Lc23NeetCode {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length < 1) {
            return null;
        }
        // 归并排序吧
        return mergeSort(lists, 0, lists.length - 1);
    }

    private ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (end - start == 1) {
            return merge(lists[start], lists[end]);
        } else if (end - start == 0) {
            return lists[start];
        } else if (end - start < 0) {
            return null;
        }
        int mid = (start + end) >> 1;
        ListNode left = mergeSort(lists, start, mid);
        ListNode right = mergeSort(lists, mid + 1, end);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }
        return merge(left, right);
    }

    /**
     * 合并2个链表
     * 一定要用烧饼节点
     * 
     * @param left
     * @param right
     * @return
     */
    private ListNode merge(ListNode left, ListNode right) {
        ListNode ans = new ListNode();
        ListNode pre = ans;
        ListNode curLeft = left;
        ListNode curRight = right;
        while (curLeft != null && curRight != null) {
            if (curLeft.val <= curRight.val) {
                pre.next = curLeft;
                curLeft = curLeft.next;
            } else {
                pre.next = curRight;
                curRight = curRight.next;
            }
            pre = pre.next;
        }
        if (curLeft == null) {
            pre.next = curRight;
        } else {
            pre.next = curLeft;
        }
        return ans.next;
    }
}

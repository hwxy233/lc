package com.hwxy.code.leetcode.order.l200.l141;

import java.util.HashSet;
import java.util.Set;

import com.hwxy.code.ds.ListNode;

/**
 * 141. 环形链表
 * https://leetcode.cn/problems/linked-list-cycle/
 * 
 * @author hwxy
 * @date 2022/05/28
 **/
public class Lc141 {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    /**
     * 快慢指针
     * 
     * @param head
     * @return
     */
    public boolean hasCycleTwoPointer(ListNode head) {
        if (head == null) {
            return false;
        }
        // 快慢指针,一个一次走一步,另一个一次走2步,如果相遇说明有环
        ListNode left = head;
        ListNode right = head.next;
        while (left != right) {
            // 说明能到结尾,right要先判断
            if (right == null || right.next == null) {
                return false;
            }
            left = left.next;
            right = right.next.next;
        }
        return true;
    }
}

package com.hwxy.leetcode.order.l200.l142;

import com.hwxy.leetcode.type.linkedlist.ListNode;

/**
 * 142. 环形链表 II
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc142 {
    public static void main(String[] args) {
        Lc142 lc142 = new Lc142();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        System.out.println(lc142.detectCycle(l1).val);
    }

    /**
     * 双指针法(快慢指针) + 公式推导
     * 
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        // 因为fast一次移动2个,所以要判断fast不为null
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 相遇了
            if (fast == slow) {
                // 相遇后根据公式推导从head到入环的距离 == 相遇节点到入环的距离,所以重置为head开始同时移动
                slow = head;
                // 再次相遇说明是在入环
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}

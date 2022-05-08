package com.hwxy.code.leetcode.order.l100.l21;

import com.hwxy.code.ds.ListNode;

/**
 * 21. 合并两个有序链表
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * 
 * @author hwxy
 * @date 2022/05/08
 **/
public class Lc21 {
    /**
     * 只要维护一个烧饼节点和一个pre就很容易了
     * 
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        // 维护一个烧饼节点,变容易
        ListNode preHead = new ListNode(-1);
        // 只要维护一个pre每次pre指向2个里面小的即可然后移动pre,最后对非null的合并
        ListNode pre = preHead;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            // 移动pre
            pre = pre.next;
        }
        // 把没遍历完的接到后面
        pre.next = list1 == null ? list2 : list1;
        return preHead.next;
    }
}

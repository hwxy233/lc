package com.hwxy.code.leetcode.order.l300.l206;

import com.hwxy.code.ds.ListNode;

import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/07
 **/
public class Lc206NeetCode {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode cur = head;
        ListNode pre = null;
        while (true) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            // 说明这里是末尾了直接break
            if (next == null) {
                break;
            }
            cur = next;
        }
        return cur;
    }


}

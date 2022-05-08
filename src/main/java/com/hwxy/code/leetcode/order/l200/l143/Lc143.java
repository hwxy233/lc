package com.hwxy.code.leetcode.order.l200.l143;

import java.util.ArrayList;
import java.util.List;

import com.hwxy.code.ds.ListNode;

/**
 * 143. 重排链表
 * https://leetcode-cn.com/problems/reorder-list/
 * 
 * @author hwxy
 * @date 2022/05/08
 **/
public class Lc143 {
    /**
     * 用一个列表可以根据索引查找
     * 
     * @param head
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        List<ListNode> listNodeList = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            listNodeList.add(cur);
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        int count = 0;
        cur = new ListNode(-1);
        // 也可以i和j同时前后遍历
        while (count < listNodeList.size() / 2) {
            cur.next = listNodeList.get(count);
            cur = cur.next;
            cur.next = listNodeList.get(listNodeList.size() - 1 - count);
            cur = cur.next;
            count++;
        }
        if (listNodeList.size() % 2 == 1) {
            cur.next = listNodeList.get(count);
        }
    }
}

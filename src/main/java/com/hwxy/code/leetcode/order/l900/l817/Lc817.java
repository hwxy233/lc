package com.hwxy.code.leetcode.order.l900.l817;

import com.hwxy.code.ds.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 817. 链表组件
 * https://leetcode.cn/problems/linked-list-components/
 *
 * @author hwxy
 * @date 2022/10/12
 **/
public class Lc817 {
    public int numComponents(ListNode head, int[] nums) {
        if (head == null || nums == null || nums.length == 0) {
            return 0;
        }
        // num set
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int ans = 0;
        // 遍历node, 找num连续
        ListNode node = head;
        while (node != null) {
            if (numSet.contains(node.val)) {
                while (node != null && numSet.contains(node.val)) {
                    node = node.next;
                }
                ans++;
                if (node == null) {
                    break;
                }
            }
            node = node.next;
        }
        return ans;
    }
}

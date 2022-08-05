package com.hwxy.code.leetcode.order.l1200.l1161;

import java.util.ArrayDeque;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 1161. 最大层内元素和
 * https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/
 * 
 * @author hwxy
 * @date 2022/07/31
 **/
public class Lc1161 {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        int ans = level;
        int maxSum = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (sum > maxSum) {
                ans = level;
                maxSum = sum;
            }
            level++;
        }
        return ans;
    }
}

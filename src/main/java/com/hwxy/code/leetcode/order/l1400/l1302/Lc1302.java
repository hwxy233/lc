package com.hwxy.code.leetcode.order.l1400.l1302;

import java.util.ArrayDeque;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 1302. 层数最深叶子节点的和
 * https://leetcode.cn/problems/deepest-leaves-sum/
 * 
 * @author hwxy
 * @date 2022/08/17
 **/
public class Lc1302 {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode parent = queue.poll();
                sum += parent.val;
                if (parent.left != null) {
                    queue.add(parent.left);
                }
                if (parent.right != null) {
                    queue.add(parent.right);
                }
            }
            ans = sum;
        }
        return ans;
    }
}

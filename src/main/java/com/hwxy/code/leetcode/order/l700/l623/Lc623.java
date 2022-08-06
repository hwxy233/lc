package com.hwxy.code.leetcode.order.l700.l623;

import java.util.ArrayDeque;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 623. 在二叉树中增加一行
 * https://leetcode.cn/problems/add-one-row-to-tree/
 * 
 * @author hwxy
 * @date 2022/08/05
 **/
public class Lc623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth < 1) {
            return root;
        }
        // 层数为1时新建树
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        int level = 1;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (level != depth - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
        }
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode newLeft = new TreeNode(val);
            newLeft.left = node.left;
            node.left = newLeft;
            TreeNode newRight = new TreeNode(val);
            newRight.right = node.right;
            node.right = newRight;
        }
        return root;
    }
}

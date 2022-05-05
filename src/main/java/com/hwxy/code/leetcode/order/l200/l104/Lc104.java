package com.hwxy.code.leetcode.order.l200.l104;

import com.hwxy.index.leetcode.everyday.tree.TreeNode;

/**
 * 104. 二叉树的最大深度
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 * 
 * @author hwxy
 * @date 2022/02/02
 **/
public class Lc104 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calDepth(root);
    }

    /**
     * 后序
     * 
     * @param root
     * @return 这层的高度
     */
    private int calDepth(TreeNode root) {
        // 叶子节点的高度为0
        if (root == null) {
            return 0;
        }
        int leftDepth = calDepth(root.left);
        int rightDepth = calDepth(root.right);
        // 左右子树的最大高度 + 1就是root这层的高度
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

package com.hwxy.order.l200.l110;

import com.hwxy.type.tree.TreeNode;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 * 
 * @author hwxy
 * @date 2022/02/02
 **/
public class Lc110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return calDepth(root) != -1;
    }

    /**
     * 返回当前节点的高度
     * 后序
     * 
     * @param root
     * @return -1如果不平衡了
     */
    private int calDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = calDepth(root.left);
        if (leftDepth == -1) {
            return -1;
        }
        int rightDepth = calDepth(root.right);
        if (rightDepth == -1) {
            return -1;
        }
        // 判断下高度
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return -1;
        }
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

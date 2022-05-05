package com.hwxy.code.leetcode.order.l200.l111;

import com.hwxy.ds.TreeNode;

/**
 * 111. 二叉树的最小深度
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 * 
 * @author hwxy
 * @date 2022/02/02
 **/
public class Lc111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return calDepth(root);
    }

    /**
     * 后序遍历
     * 与求最大深度不同,需要区分左右子树空的各种情况
     * 
     * @param root
     * @return
     */
    private int calDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftDep = calDepth(left);
        int rightDep = calDepth(right);
        // 左子树不为空,右子树为空
        if (left != null && right == null) {
            return leftDep + 1;
        }
        // 右子树不为空,左子树为空
        if (left == null && right != null) {
            return rightDep + 1;
        }
        return Math.min(leftDep, rightDep) + 1;
    }
}

package com.hwxy.code.leetcode.order.l200.l101;

import com.hwxy.code.ds.TreeNode;

/**
 * 101. 对称二叉树
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 
 * @author hwxy
 * @date 2022/02/02
 **/
public class Lc101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }

    /**
     * 相当于后序
     * 
     * @param left
     * @param right
     * @return
     */
    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null) {
            return false;
        } else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            // 值不相等
            return false;
        }
        // 单层逻辑,比较外层和内层
        boolean outsideSame = compare(left.left, right.right);
        boolean insideSame = compare(left.right, right.left);
        // 内外都要相等
        return outsideSame && insideSame;
    }
}

package com.hwxy.code.leetcode.order.l300.l236;

import com.hwxy.ds.TreeNode;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return find(root, p, q);
    }

    /**
     * 后序遍历
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件,找到了
        if (root == null || root == p || root == q) {
            return root;
        }
        // 左
        TreeNode left = find(root.left, p, q);
        // 右
        TreeNode right = find(root.right, p, q);
        // 中,自己就是
        if (left != null && right != null) {
            return root;
        } else if (left == null && right != null) {
            // 说明出现在了右边
            return right;
        } else if (left != null && right == null) {
            // 说明出现在了左边
            return left;
        } else {
            return null;
        }

    }
}

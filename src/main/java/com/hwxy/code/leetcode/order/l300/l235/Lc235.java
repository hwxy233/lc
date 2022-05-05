package com.hwxy.code.leetcode.order.l300.l235;

import com.hwxy.index.leetcode.everyday.tree.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return find(root, p, q);
    }

    /**
     * 利用BST性质,前序遍历,要排除着想
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return root;
        }
        // 中,没有逻辑
        // 左,都小于当前值向左找
        if (root.val > p.val && root.val > q.val) {
            // 说明在左子树里
            TreeNode left = find(root.left, p, q);
            if (left != null) {
                return left;
            }
        }
        // 右,都大于当前值向右找
        if (root.val < p.val && root.val < q.val) {
            TreeNode right = find(root.right, p, q);
            // 说明在you子树里
            if (right != null) {
                return right;
            }
        }
        // 找到了
        return root;
    }
}

package com.hwxy.code.leetcode.order.l300.l236;

import com.hwxy.code.ds.TreeNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/07/01
 **/
public class Lc236R {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return dfs(root, p.val, q.val);
    }

    /**
     * 后续遍历因为要知道子树再判断根
     * 
     * @param root
     * @param pv
     * @param qv
     * @return
     */
    private TreeNode dfs(TreeNode root, int pv, int qv) {
        if (root == null) {
            return null;
        }
        // 说明找到了p或q
        if (root.val == pv || root.val == qv) {
            return root;
        }
        // 先确定左右然后再判断根
        TreeNode left = dfs(root.left, pv, qv);
        TreeNode right = dfs(root.right, pv, qv);
        // 分布于左右2测
        if (left != null && right != null) {
            return root;
        }
        if (left == null) {
            return right;
        }
        // 相当于null
        return left;
    }
}

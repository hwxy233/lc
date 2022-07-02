package com.hwxy.code.leetcode.order.l300.l235;

import com.hwxy.code.ds.TreeNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/07/01
 **/
public class Lc235Nc {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        return dfs(root, p.val, q.val);
    }

    private TreeNode dfs(TreeNode root, int pv, int qv) {
        // 根>p和q,说明在左子树中
        if (root.val > pv && root.val > qv) {
            return dfs(root.left, pv, qv);
        }
        // 根<p和q,说明在右子树
        if (root.val < pv && root.val < qv) {
            return dfs(root.right, pv, qv);
        }
        // 说明一边一个或者是当前是p和q之一
        return root;
    }
}

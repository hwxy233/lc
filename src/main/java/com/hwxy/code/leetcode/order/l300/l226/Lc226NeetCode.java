package com.hwxy.code.leetcode.order.l300.l226;

import com.hwxy.code.ds.TreeNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/28
 **/
public class Lc226NeetCode {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        dfs(root);
        return root;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        dfs(root.left);
        dfs(root.right);
    }
}

package com.hwxy.code.leetcode.order.l1000.l965;

import com.hwxy.code.ds.TreeNode;

/**
 * 965. 单值二叉树
 * https://leetcode.cn/problems/univalued-binary-tree/
 * 
 * @author hwxy
 * @date 2022/05/24
 **/
public class Lc965 {

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return dfs(root);
    }

    /**
     * 先序遍历
     * 先将根和左右子树比较,然后dfs左和右
     * 
     * @param root
     * @return
     */
    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 先将根和左右子树比较,然后dfs左和右
        if (root.left != null && root.val != root.left.val) {
            return false;
        }
        if (root.right != null && root.val != root.right.val) {
            return false;
        }
        return dfs(root.left) && dfs(root.right);
    }
}

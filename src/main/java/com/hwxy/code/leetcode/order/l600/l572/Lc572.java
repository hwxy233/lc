package com.hwxy.code.leetcode.order.l600.l572;

import com.hwxy.code.ds.TreeNode;

/**
 * 572. 另一棵树的子树
 * https://leetcode.cn/problems/subtree-of-another-tree/
 * 
 * @author hwxy
 * @date 2022/06/07
 **/
public class Lc572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return subRoot == null;
        }
        return dfs(root, subRoot);
    }

    /**
     * 子树不是子结构
     * 子树要求相等
     * 所以要么本身是subRoot要么左或右是subRoot
     * 
     * @param root
     * @param subRoot
     * @return
     */
    private boolean dfs(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        return check(root, subRoot) || dfs(root.left, subRoot) || dfs(root.right, subRoot);
    }

    /**
     * 值相等 && 左右子树相等
     * 
     * @param root
     * @param subRoot
     * @return
     */
    private boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }
        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        return check(root.left, subRoot.left) && check(root.right, subRoot.right);
    }
}

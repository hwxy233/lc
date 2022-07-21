package com.hwxy.code.leetcode.order.l900.l814;

import com.hwxy.code.ds.TreeNode;

/**
 * 814. 二叉树剪枝
 * https://leetcode.cn/problems/binary-tree-pruning/
 * 
 * @author hwxy
 * @date 2022/07/21
 **/
public class Lc814 {

    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 如果全是0则返回null
        if (dfs(root)) {
            return null;
        }
        return root;
    }

    /**
     * 后续遍历
     * 
     * @param root
     * @return 不包含1
     */
    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean leftL = dfs(root.left);
        if (leftL) {
            root.left = null;
        }
        boolean leftR = dfs(root.right);
        if (leftR) {
            root.right = null;
        }
        // 左右子树都不包含并且自己也不是1才算不包含
        return leftL && leftR && root.val == 0;
    }
}

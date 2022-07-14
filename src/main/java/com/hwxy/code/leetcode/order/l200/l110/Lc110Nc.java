package com.hwxy.code.leetcode.order.l200.l110;

import com.hwxy.code.ds.TreeNode;

/**
 * 110. 平衡二叉树
 * https://leetcode-cn.com/problems/balanced-binary-tree/
 *
 * @author hwxy
 * @date 2022/07/13
 **/
public class Lc110Nc {
    private boolean ans;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        ans = true;
        dfs(root);
        return ans;
    }

    /**
     * 后续遍历
     * 每次比较左右的高度如果绝对值差>1了就将答案改为false
     * 返回左右高度的较大值
     * 
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null || !ans) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans = false;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

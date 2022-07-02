package com.hwxy.code.leetcode.order.l200.l124;

import com.hwxy.code.ds.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/
 * 
 * @author hwxy
 * @date 2022/07/02
 **/
public class Lc124 {
    private int ans;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }

    /**
     * 后续遍历三选二
     * 这样能和父节点相连
     * 求左边最大和右边最大时去掉负数相当于不考虑那条路径
     * 
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = Math.max(0, dfs(root.left));
        int rightMax = Math.max(0, dfs(root.right));
        ans = Math.max(ans, leftMax + rightMax + root.val);
        return Math.max(leftMax + root.val, rightMax + root.val);
    }
}

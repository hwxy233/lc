package com.hwxy.code.leetcode.order.l600.l543;

import com.hwxy.code.ds.TreeNode;

/**
 * 543. 二叉树的直径
 * https://leetcode.cn/problems/diameter-of-binary-tree/
 * 
 * @author hwxy
 * @date 2022/07/13
 **/
public class Lc543 {
    private int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        dfs(root);
        return Math.max(0, ans - 1);
    }

    /**
     * 后续遍历,一个路径=左路径+右路径+1(当前节点)
     * 但是父节点只能使用左路径或右路径+1(当前节点)
     * 
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftLength = dfs(root.left);
        int rightLength = dfs(root.right);
        ans = Math.max(ans, leftLength + rightLength + 1);
        return Math.max(leftLength, rightLength) + 1;
    }
}

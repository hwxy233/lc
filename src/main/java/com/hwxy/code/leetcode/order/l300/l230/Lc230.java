package com.hwxy.code.leetcode.order.l300.l230;

import com.hwxy.code.ds.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 * https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * 
 * @author hwxy
 * @date 2022/07/02
 **/
public class Lc230 {
    private int kMin;
    private int k;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null || k < 1) {
            return -1;
        }
        this.k = k;
        kMin = -1;
        dfs(root);
        return kMin;
    }

    /**
     * 中序遍历
     * 
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null || k == 0) {
            return;
        }
        dfs(root.left);
        if (k > 0) {
            kMin = root.val;
            k--;
        } else {
            return;
        }
        dfs(root.right);
    }
}

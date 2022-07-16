package com.hwxy.code.leetcode.order.l1500.l1448;

import com.hwxy.code.ds.TreeNode;

/**
 * 1448. 统计二叉树中好节点的数目
 * https://leetcode.cn/problems/count-good-nodes-in-binary-tree/
 * 
 * @author hwxy
 * @date 2022/07/14
 **/
public class Lc1448 {
    private int ans;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    /**
     * 先序遍历,参数记录一个当前的最大值
     * 
     * @param root
     * @param max
     */
    private void dfs(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            ans++;
            max = root.val;
        }
        dfs(root.left, max);
        dfs(root.right, max);
    }
}

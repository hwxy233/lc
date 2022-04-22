package com.hwxy.leetcode.order.l200.l112;

import com.hwxy.leetcode.type.tree.TreeNode;

/**
 * 112. 路径总和
 * https://leetcode-cn.com/problems/path-sum/
 * 
 * @author hwxy
 * @date 2022/02/02
 **/
public class Lc112 {
    public static void main(String[] args) {
        System.out.println(new Lc112().hasPathSum(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5, null, null)), new TreeNode(3, null, null)),
                8));
    }

    /**
     * 这样方便回溯
     */
    private int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        this.targetSum = targetSum;
        return calSum(root);
    }

    /**
     * 到叶子节点求和
     * 对target操作
     * 
     * @param root
     * @return
     */
    private boolean calSum(TreeNode root) {
        // 中
        targetSum -= root.val;
        // 叶子节点操作
        if (root.left == null && root.right == null) {
            if (targetSum == 0) {
                return true;
            }
        }
        if (root.left != null) {
            boolean res = calSum(root.left);
            // 只要这次可以就直接返回
            if (res) {
                return res;
            }
        }
        if (root.right != null) {
            boolean res = calSum(root.right);
            // 只要这次可以就直接返回
            if (res) {
                return res;
            }
        }
        // 回溯
        targetSum += root.val;
        // 都不满足
        return false;
    }
}

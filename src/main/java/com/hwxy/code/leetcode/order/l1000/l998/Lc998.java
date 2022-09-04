package com.hwxy.code.leetcode.order.l1000.l998;

import com.hwxy.code.ds.TreeNode;

/**
 * 998. 最大二叉树 II
 *
 * <p>https://leetcode.cn/problems/maximum-binary-tree-ii/
 *
 * @author hwxy
 * @date 2022/08/30
 */
public class Lc998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        return dfs(root, new TreeNode(val));
    }

    /**
     * 意思是讲treeNode加到数组最后再重新建树的话应该是什么样子
     *
     * <p>因为加载最后其实就肯定会出现在右子树中
     *
     * <p>本质上只有2种情况:
     *
     * <p>1. root小于treeNode了,那么root就是treeNode的左
     *
     * <p>2. 不断遍历右子树,如果遍历到最后到null了那么自己就是右子树
     *
     * @param root
     * @param treeNode
     * @return
     */
    private TreeNode dfs(TreeNode root, TreeNode treeNode) {
        if (root == null || treeNode.val > root.val) {
            treeNode.left = root;
            return treeNode;
        }
        root.right = dfs(root.right, treeNode);
        return root;
    }
}

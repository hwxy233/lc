package com.hwxy.order.l700.l653;

/**
 * 653. 两数之和 IV - 输入 BST
 * https://leetcode-cn.com/problems/two-sum-iv-input-is-a-bst/
 * 
 * @author hwxy
 * @date 2022/03/23
 **/
public class Lc653 {
    private TreeNode hRoot;

    /**
     * 2次dfs
     * 
     * @param root
     * @param k
     * @return
     */
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        hRoot = root;
        return dfs(root, k);
    }

    /**
     * 对每个节点进行dfs
     *
     * @param root
     * @param k
     * @return
     */
    private boolean dfs(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        return (find(hRoot, k - root.val, root.val))
                || dfs(root.left, k)
                || dfs(root.right, k);
    }


    /**
     * 从根节点二叉搜索树性质搜索
     *
     * @param root
     * @param val
     * @param usedVal
     * @return
     */
    private boolean find(TreeNode root, int val, int usedVal) {
        if (root == null) {
            return false;
        }
        if (root.val == val) {
            return root.val != usedVal;
        }
        if (val < root.val) {
            return find(root.left, val, usedVal);
        }
        return find(root.right, val, usedVal);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

package com.hwxy.code.leetcode.order.l700.l669;

import com.hwxy.code.ds.TreeNode;

/**
 * 669. 修剪二叉搜索树
 *
 * <p>https://leetcode.cn/problems/trim-a-binary-search-tree/
 *
 * @author hwxy
 * @date 2022/09/10
 */
public class Lc669 {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        return dfs(root, low, high);
    }

    /**
     * 因为是BST所以有左 < root < 右 的性质,所以可以检查root.val然后分情况讨论,先序遍历
     *
     * <p>1. root.val > high,说明root以及right都要舍弃
     *
     * <p>2. root.val < low,说明root以及left都要舍弃
     *
     * <p>3. root.val在区间,这是分别dfs左和右作为root的左和右,然后返回root
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    private TreeNode dfs(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val > high) {
            return dfs(root.left, low, high);
        } else if (root.val < low) {
            return dfs(root.right, low, high);
        } else {
            root.left = dfs(root.left, low, high);
            root.right = dfs(root.right, low, high);
            return root;
        }
    }
}

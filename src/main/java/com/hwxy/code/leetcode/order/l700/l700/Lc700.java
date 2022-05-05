package com.hwxy.code.leetcode.order.l700.l700;

import com.hwxy.index.leetcode.everyday.tree.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return root;
        }
        return findVal(root, val);
    }

    /**
     * BST 左小,右大
     * 
     * @param root
     * @param val
     * @return
     */
    private TreeNode findVal(TreeNode root, int val) {
        // 终止条件(中)
        if (root == null || root.val == val) {
            return root;
        }
        // 找右
        if (val > root.val) {
            return findVal(root.right, val);
        }
        // 找左
        if (val < root.val) {
            return findVal(root.left, val);
        }
        // 没有找到
        return null;
    }

}

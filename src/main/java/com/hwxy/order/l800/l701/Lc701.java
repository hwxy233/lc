package com.hwxy.order.l800.l701;

import com.hwxy.type.tree.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insert(root, val);
    }

    /**
     * 后序
     * 
     * @param root
     * @param val
     * @return
     */
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insert(root.left, val);
        }
        if (root.val < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }
}

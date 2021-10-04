package com.hwxy.order.l100.l94;

import java.util.LinkedList;
import java.util.List;

import com.hwxy.type.tree.TreeNode;

/**
 * 二叉树中序列
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Lc94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3, null, null)), null);
        Lc94 lc94 = new Lc94();
        System.out.println(lc94.inorderTraversal(root));
    }

    private LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        backtracking(root);
        return res;
    }

    private void backtracking(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历,左-根-右
        backtracking(root.left);
        res.add(root.val);
        backtracking(root.right);
    }
}

package com.hwxy.code.leetcode.order.l100.l94;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


/**
 * 二叉树中序列
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class Lc94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null));
        Lc94 lc94 = new Lc94();
        System.out.println(lc94.inorderTraversal(root));
    }

    private LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        // backtracking(root);
        stackTracking(root);
        return res;
    }

    private void stackTracking(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        // 先将根和左不断的入栈,如果到底了就开始弹栈并压右
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
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

    static class TreeNode {
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

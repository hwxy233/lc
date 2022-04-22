package com.hwxy.leetcode.order.l200.l144;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.hwxy.leetcode.type.tree.TreeNode;

/**
 * 二叉树前序
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author hwxy
 * @date 2021/10/04
 **/
public class Lc144 {

    public static void main(String[] args) {
        Lc144 lc144 = new Lc144();
        System.out.println(lc144.preorderTraversal(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null))));
    }

    private LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // backtracking(root);
        stackTracking(root);
        return res;
    }

    private void backtracking(TreeNode root) {
        // null终止条件
        if (root == null) {
            return;
        }
        // 前序遍历:根-左-右
        res.add(root.val);
        backtracking(root.left);
        backtracking(root.right);
    }

    /**
     * 非递归用栈,入栈顺序,根-右-左
     * 
     * @param treeNode
     */
    private void stackTracking(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        // 前序,根-左-右
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode root = stack.pop();
            if (root == null) {
                continue;
            }
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

}

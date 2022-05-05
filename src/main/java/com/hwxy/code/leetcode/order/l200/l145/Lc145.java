package com.hwxy.code.leetcode.order.l200.l145;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.hwxy.code.ds.TreeNode;

/**
 * 二叉树后序
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author hwxy
 * @date 2021/10/04
 **/
public class Lc145 {
    public static void main(String[] args) {
        Lc145 lc145 = new Lc145();
        System.out.println(lc145.postorderTraversal(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null))));
    }

    private LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        // backtracking(root);
        normalTracking(root);
        return res;
    }

    /**
     * 非递归遍历
     * 
     * @param treeNode
     */
    private void normalTracking(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        // 后序,左-右-根
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode root = stack.pop();
            if (root == null) {
                continue;
            }
            res.add(root.val);
            // 如果是前序的话,这里是先右后左,这里交换后数组的顺序就是根-右-左
            if (root.left != null) {
                stack.push(root.left);
            }
            if (root.right != null) {
                stack.push(root.right);
            }
        }
        // 最后将整个数组反转,根-右-左 => 左-右-根
        Collections.reverse(res);
    }

    private void backtracking(TreeNode root) {
        if (root == null) {
            return;
        }
        // 后序遍历,左-右-根
        backtracking(root.left);
        backtracking(root.right);
        res.add(root.val);
    }
}

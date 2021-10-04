package com.hwxy.order.l200.l144;

import java.util.LinkedList;
import java.util.List;

import com.hwxy.type.tree.TreeNode;

/**
 * 二叉树前序
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author hwxy
 * @date 2021/10/04
 **/
public class Lc144 {

    private LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        backtracking(root);
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
}

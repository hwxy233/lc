package com.hwxy.order.l200.l145;

import java.util.LinkedList;
import java.util.List;

import com.hwxy.type.tree.TreeNode;

/**
 * 二叉树后序
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 *
 * @author hwxy
 * @date 2021/10/04
 **/
public class Lc145 {
    private LinkedList<Integer> res = new LinkedList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        backtracking(root);
        return res;
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

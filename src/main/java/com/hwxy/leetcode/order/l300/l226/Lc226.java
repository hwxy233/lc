package com.hwxy.leetcode.order.l300.l226;


import java.util.LinkedList;
import java.util.Queue;

import com.hwxy.leetcode.type.tree.TreeNode;

/**
 * 226. 翻转二叉树
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * 
 * @author hwxy
 * @date 2022/02/02
 **/
public class Lc226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        // return swap(root);
        return level(root);
    }

    /**
     * 层次遍历也可以
     * 
     * @param root
     * @return
     */
    private TreeNode level(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode left = cur.left;
            TreeNode right = cur.right;
            cur.left = right;
            cur.right = left;
            if (left != null) {
                queue.add(left);
            }
            if (right != null) {
                queue.add(right);
            }
        }
        return root;
    }

    /**
     * 深度优先
     * 翻转左右后(后序和前序都可以),再进行交换
     *
     * @param root
     * @return
     */
    private TreeNode swap(TreeNode root) {
        if (root == null) {
            return root;
        }
        // 翻转左
        TreeNode left = root.left;
        swap(left);
        // 翻转右
        TreeNode right = root.right;
        swap(right);
        // 交换
        root.left = right;
        root.right = left;
        return root;
    }
}

package com.hwxy.code.leetcode.order.l200.l102;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 102. 层次遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author hwxy
 * @date 2021/10/04
 **/
public class Lc102 {

    public static void main(String[] args) {
        Lc102 lc102 = new Lc102();
        System.out.println(lc102.levelOrder(
                new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null))));
    }

    private LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            // 用size记录这层的node数
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
                    continue;
                }
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}

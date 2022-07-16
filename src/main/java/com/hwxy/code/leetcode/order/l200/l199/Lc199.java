package com.hwxy.code.leetcode.order.l200.l199;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 199. 二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author hwxy
 * @date 2021/10/17
 **/
public class Lc199 {

    public static void main(String[] args) {
        // System.out.println(new Lc199()
        // .rightSideView(new TreeNode(1, new TreeNode(2, null, new TreeNode(5, null, null)),
        // new TreeNode(3, null, new TreeNode(4, null, null)))));
        System.out.println(new Lc199()
                .rightSideView(new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null),
                        new TreeNode(3, null, null))));
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                // 右视图就是右边的第一个吗,每层只要第一个就好了
                if (i == 0) {
                    res.add(node.val);
                }
                // 然后先放右再放左
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
            }
        }
        return res;
    }
}

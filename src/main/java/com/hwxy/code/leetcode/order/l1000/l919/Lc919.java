package com.hwxy.code.leetcode.order.l1000.l919;

import java.util.ArrayDeque;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/07/25
 **/
public class Lc919 {

}


class CBTInserter {
    private TreeNode root;

    private Queue<TreeNode> queue;

    public CBTInserter(TreeNode root) {
        this.root = root;
        queue = new ArrayDeque<>();
        queue.add(root);
    }

    public int insert(int val) {
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.peek();
            // 左右都不空
            if (treeNode.left != null && treeNode.right != null) {
                queue.poll();
                queue.offer(treeNode.left);
                queue.offer(treeNode.right);
                continue;
            }
            // 左空
            if (treeNode.left == null) {
                treeNode.left = new TreeNode(val);
                queue.offer(treeNode.left);
                return treeNode.val;
            }
            // 右空
            queue.offer(treeNode.left);
            treeNode.right = new TreeNode(val);
            queue.offer(treeNode.right);
            queue.poll();
            return treeNode.val;
        }
        return -1;
    }

    public TreeNode get_root() {
        return root;
    }
}

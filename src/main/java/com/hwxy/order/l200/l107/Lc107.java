package com.hwxy.order.l200.l107;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.hwxy.type.tree.TreeNode;

/**
 * 反向遍历二叉树
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 *
 * @author hwxy
 * @date 2021/10/07
 **/
public class Lc107 {

    private LinkedList<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> raw = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    continue;
                }
                raw.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.addFirst(raw);
        }
        return res;
    }
}

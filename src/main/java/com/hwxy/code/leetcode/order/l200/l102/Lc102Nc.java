package com.hwxy.code.leetcode.order.l200.l102;

import java.util.*;

import com.hwxy.code.ds.TreeNode;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * 
 * @author hwxy
 * @date 2022/07/01
 **/
public class Lc102Nc {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelAns = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                levelAns.add(cur.val);
            }
            ans.add(levelAns);
        }
        return ans;
    }
}

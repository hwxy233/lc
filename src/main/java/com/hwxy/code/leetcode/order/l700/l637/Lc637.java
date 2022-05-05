package com.hwxy.code.leetcode.order.l700.l637;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 二叉树层平均值
 * https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/
 *
 * @author hwxy
 * @date 2021/10/17
 **/
public class Lc637 {
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Double> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                sum += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(sum / size);
        }
        return res;
    }
}

package com.hwxy.code.leetcode.order.l700.l662;

import com.hwxy.code.ds.Pair;
import com.hwxy.code.ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 662. 二叉树最大宽度
 *
 * <p>https://leetcode.cn/problems/maximum-width-of-binary-tree/
 *
 * @author hwxy
 * @date 2022/08/27
 */
public class Lc662 {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 1;
        // 用记录下标代替存null,存null回爆内存
        List<Pair<TreeNode, Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root, 1));
        while (!arr.isEmpty()) {
            List<Pair<TreeNode, Integer>> tmp = new ArrayList<>();
            for (Pair<TreeNode, Integer> pair : arr) {
                TreeNode node = pair.getKey();
                int index = pair.getValue();
                if (node.left != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.left, index * 2));
                }
                if (node.right != null) {
                    tmp.add(new Pair<TreeNode, Integer>(node.right, index * 2 + 1));
                }
            }
            res = Math.max(res, arr.get(arr.size() - 1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }
}

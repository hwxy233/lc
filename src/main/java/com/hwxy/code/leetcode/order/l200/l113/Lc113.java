package com.hwxy.code.leetcode.order.l200.l113;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hwxy.index.leetcode.everyday.tree.TreeNode;

/**
 * 113. 路径总和 II
 * https://leetcode-cn.com/problems/path-sum-ii/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc113 {
    private List<List<Integer>> res;
    private int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return Collections.emptyList();
        }
        res = new LinkedList<>();
        target = targetSum;
        LinkedList<Integer> curRes = new LinkedList<>();
        findPath(root, curRes);
        return res;
    }

    /**
     * 前序遍历
     * 
     * @param root
     * @param curRes
     */
    private void findPath(TreeNode root, LinkedList<Integer> curRes) {
        // 中
        target -= root.val;
        curRes.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == 0) {
                res.add(new LinkedList<>(curRes));
            }
        }
        // 左
        if (root.left != null) {
            findPath(root.left, curRes);
            // 回溯
            curRes.removeLast();
            target += root.val;
        }
        // 右
        if (root.right != null) {
            findPath(root.right, curRes);
            // 回溯
            curRes.removeLast();
            target += root.val;
        }
    }
}

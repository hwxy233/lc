package com.hwxy.code.leetcode.order.l100.l100;

import com.hwxy.code.ds.TreeNode;

/**
 * 100. 相同的树
 * https://leetcode.cn/problems/same-tree/
 * 
 * @author hwxy
 * @date 2022/05/28
 **/
public class Lc100LeetCode {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        return dfs(p, q);
    }

    private boolean dfs(TreeNode p, TreeNode q) {
        if ((p == null && q != null) || (p != null && q == null)) {
            return false;
        } else if (p == null) {
            return true;
        }
        boolean rootAns = p.val == q.val;
        return rootAns && dfs(p.left, q.left) && dfs(p.right, q.right);
    }
}

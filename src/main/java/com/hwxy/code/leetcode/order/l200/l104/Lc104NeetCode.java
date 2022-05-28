package com.hwxy.code.leetcode.order.l200.l104;

import com.hwxy.code.ds.TreeNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/05/28
 **/
public class Lc104NeetCode {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    /**
     * 不能使用全局变量
     * 这种写法是到叶子返回计数
     * 
     * @param root
     * @param depth
     * @return
     */
    private int dfs(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int leftDepth = dfs(root.left, depth + 1);
        int rightDepth = dfs(root.right, depth + 1);
        return Math.max(leftDepth, rightDepth);
    }

    /**
     * 另一种写法可以不用参数变量
     * 这样到叶子会+1
     * 
     * @param root
     * @return
     */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = dfs(root.left);
        int rightDepth = dfs(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}

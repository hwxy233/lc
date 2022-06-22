package com.hwxy.code.leetcode.order.l600.l513;

import com.hwxy.code.ds.TreeNode;

/**
 * 513. 找树左下角的值
 * https://leetcode.cn/problems/find-bottom-left-tree-value/
 * 
 * @author hwxy
 * @date 2022/06/22
 **/
public class Lc513 {
    private TreeNode a;
    private int maxHeight;

    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxHeight = 0;
        a = null;
        dfs(root, 1);
        return a.val;

        // 层次遍历
        // Queue<TreeNode> queue = new ArrayDeque<>();
        // queue.add(root);
        // TreeNode ans = root;
        // while (!queue.isEmpty()) {
        // int levelSize = queue.size();
        // for (int i = 0; i < levelSize; i++) {
        // TreeNode cur = queue.poll();
        // if (i == 0) {
        // ans = cur;
        // }
        // if (cur.left != null) {
        // queue.offer(cur.left);
        // }
        // if (cur.right != null) {
        // queue.offer(cur.right);
        // }
        // }
        // }
        // return ans.val;
    }

    /**
     * 记录一个层高和最高层高
     * 一定是左边先遍历到,先遍历到的是答案
     * 
     * @param root
     * @param height
     */
    private void dfs(TreeNode root, int height) {
        if (root == null) {
            return;
        }
        if (height > maxHeight) {
            a = root;
            maxHeight = height;
        }
        height++;
        dfs(root.left, height);
        dfs(root.right, height);
    }
}

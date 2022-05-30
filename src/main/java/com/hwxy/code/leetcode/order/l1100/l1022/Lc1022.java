package com.hwxy.code.leetcode.order.l1100.l1022;

import com.hwxy.code.ds.TreeNode;

/**
 * 1022. 从根到叶的二进制数之和
 * https://leetcode.cn/problems/sum-of-root-to-leaf-binary-numbers/
 * 
 * @author hwxy
 * @date 2022/05/30
 **/
public class Lc1022 {
    private int ans;

    private StringBuilder sb;

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ans = 0;
        sb = new StringBuilder();
        // 先序可以直接用参数记录也可以回溯
        dfs(root);
        // dfs(root, 0);
        return ans;
    }

    /**
     * 先序不带sb
     * 
     * @param root
     * @param preSum
     */
    private void dfs(TreeNode root, int preSum) {
        preSum = preSum * 2 + root.val;
        if (root.left == null && root.right == null) {
            ans += preSum;
            return;

        }
        if (root.left != null) {
            dfs(root.left, preSum);
        }
        if (root.right != null) {
            dfs(root.right, preSum);
        }
    }

    /**
     * 先序带sb
     * 
     * @param root
     */
    private void dfs(TreeNode root) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans += Integer.parseInt(sb.toString(), 2);
            return;
        }
        if (root.left != null) {
            dfs(root.left);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (root.right != null) {
            dfs(root.right);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

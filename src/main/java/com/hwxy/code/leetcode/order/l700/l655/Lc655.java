package com.hwxy.code.leetcode.order.l700.l655;

import com.hwxy.code.ds.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 655. 输出二叉树
 * https://leetcode.cn/problems/print-binary-tree/
 *
 * @author hwxy
 * @date 2022/08/22
 **/
public class Lc655 {
    public List<List<String>> printTree(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        int m = getHeight(root);
        List<List<String>> ans = new ArrayList<>(m);
        int n = (int) (Math.pow(2, m) - 1);
        for (int i = 0; i < m; i++) {
            ans.add(new ArrayList<>(n));
        }
        dfs(ans, root, 0, (n - 1) / 2, n, m - 1);
        return ans;
    }

    private void dfs(List<List<String>> ans, TreeNode root, int r, int c, int n, int height) {
        if (root == null) {
            return;
        }
        List<String> tmp = ans.get(r);
        if (tmp.isEmpty()) {
            for (int i = 0; i < n; i++) {
                tmp.add("");
            }
        }
        tmp.set(c, String.valueOf(root.val));
        dfs(ans, root.left, r + 1, (int) (c - Math.pow(2, height - r - 1)), n, height);
        dfs(ans, root.right, r + 1, (int) (c + Math.pow(2, height - r - 1)), n, height);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}

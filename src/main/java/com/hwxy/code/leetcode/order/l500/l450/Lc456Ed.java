package com.hwxy.code.leetcode.order.l500.l450;

import com.hwxy.code.ds.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 
 * @author hwxy
 * @date 2022/06/02
 **/
public class Lc456Ed {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        return dfs(root, key);
    }

    private TreeNode dfs(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            // 大了找左
            root.left = dfs(root.left, key);
        } else if (root.val < key) {
            // 小了找右
            root.right = dfs(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                // 找到左子树的右子树的最小节点作为右子树的根,root.left作为新的root
                TreeNode leftRight = root.left;
                while (leftRight.right != null) {
                    leftRight = leftRight.right;
                }
                // 代替root
                leftRight.right = root.right;
                // 返回root.left作为新的root
                return root.left;
            }
        }
        return root;
    }
}

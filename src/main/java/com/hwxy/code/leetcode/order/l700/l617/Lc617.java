package com.hwxy.code.leetcode.order.l700.l617;

import com.hwxy.index.leetcode.everyday.tree.TreeNode;

/**
 * 617. 合并二叉树
 * https://leetcode-cn.com/problems/merge-two-binary-trees/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return root1;
        }
        return buildTrees(root1, root2);
    }

    /**
     * 合并r1和r2
     * 前序遍历
     * 
     * @param root1
     * @param root2
     * @return
     */
    private TreeNode buildTrees(TreeNode root1, TreeNode root2) {
        // 终止条件,任意一方为null返回另一方
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        // 将r1作为返回值
        root1.val += root2.val;
        // 左和右
        root1.left = buildTrees(root1.left, root2.left);
        root1.right = buildTrees(root1.right, root2.right);
        return root1;
    }
}

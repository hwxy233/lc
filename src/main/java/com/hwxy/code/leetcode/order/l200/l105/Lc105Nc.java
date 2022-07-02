package com.hwxy.code.leetcode.order.l200.l105;

import com.hwxy.code.ds.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author hwxy
 * @date 2022/07/02
 **/
public class Lc105Nc {
    private int[] preorder;
    private int[] inorder;

    private int preIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0
                || preorder.length != inorder.length) {
            return null;
        }
        preIndex = 0;
        this.inorder = inorder;
        this.preorder = preorder;
        return dfs(0, inorder.length - 1);
    }

    private TreeNode dfs(int start, int end) {
        if (start == end) {
            preIndex++;
            return new TreeNode(inorder[start]);
        }
        // 先序拿当前节点值
        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        // 找到左子树的开始和结束
        int rootIndex = 0;
        for (int i = start; i <= end; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
            }
        }
        if (start <= rootIndex - 1) {
            root.left = dfs(start, rootIndex - 1);
        }
        // 找到右子树的开始和结束
        if (rootIndex + 1 <= end) {
            root.right = dfs(rootIndex + 1, end);
        }
        return root;
    }
}

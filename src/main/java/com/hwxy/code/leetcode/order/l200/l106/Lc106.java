package com.hwxy.code.leetcode.order.l200.l106;

import com.hwxy.ds.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0
                || inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    /**
     * 已后序的最后为当前节点
     * 从中序里找到值相等的作为分界点
     * [,)为左子树,[,)为右子树,并且从后序里找到长度相同的分开左和右
     * 然后构造左子树和右子树
     * 左闭右开
     * 
     * @param inorder
     * @param inStart 左闭右开
     * @param inEnd 左闭右开
     * @param postorder
     * @param postStart 左闭右开
     * @param postEnd 左闭右开
     * @return
     */
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder,
            int postStart, int postEnd) {
        // 终止条件
        if (postStart == postEnd) {
            return null;
        }
        // 当前节点
        int rootVal = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        // 到叶子了
        if (postEnd - postStart == 1) {
            return root;
        }
        // 找分界点
        int midIndex;
        for (midIndex = inStart; midIndex < inEnd; midIndex++) {
            if (inorder[midIndex] == rootVal) {
                break;
            }
        }
        // 切割中序,左闭右开,舍弃mindIndex
        int leftInorderStart = inStart;
        int leftInorderEnd = midIndex;
        int rightInorderStart = midIndex + 1;
        int rightInorderEnd = inEnd;
        // 切割后序,左闭右开,舍弃postEnd-1
        int leftPostorderStart = postStart;
        int leftPostorderEnd = postStart + midIndex - inStart;
        int rightPostorderStart = postStart + midIndex - inStart;
        int rightPostorderEnd = postEnd - 1;
        // 构建左和有
        TreeNode left = buildTree(inorder, leftInorderStart, leftInorderEnd, postorder,
                leftPostorderStart, leftPostorderEnd);
        TreeNode right = buildTree(inorder, rightInorderStart, rightInorderEnd, postorder,
                rightPostorderStart, rightPostorderEnd);
        root.left = left;
        root.right = right;
        return root;
    }
}

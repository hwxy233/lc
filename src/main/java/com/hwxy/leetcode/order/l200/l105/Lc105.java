package com.hwxy.leetcode.order.l200.l105;

import com.hwxy.leetcode.type.tree.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length == 0
                || inorder.length != preorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    /**
     * 与后序类似,只是从前序的开头开始找当前节点
     * 都是用前/后先去切,所以终止条件都是前/后序的
     * 
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
            int inEnd) {
        // 终止条件
        if (preStart == preEnd) {
            return null;
        }
        // 当前节点
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // 到叶子了
        if (preEnd - preStart == 1) {
            return root;
        }
        // 从中序找到分割点
        int midIndex;
        for (midIndex = inStart; midIndex < inEnd; midIndex++) {
            if (rootVal == inorder[midIndex]) {
                break;
            }
        }
        // 切割,左闭右开,中序的都很简单
        int leftInStart = inStart;
        int leftInEnd = midIndex;
        int rightInStart = midIndex + 1;
        int rightInEnd = inEnd;
        // 前序的主要需要加一个对应中序的长度,并且preStart已经用过了舍弃掉
        int leftPreStart = preStart + 1;
        int leftPreEnd = leftPreStart + midIndex - inStart;
        // 左闭右开的
        int rightPreStart = leftPreEnd;
        int rightPreEnd = preEnd;
        // 左和右
        root.left = buildTree(preorder, leftPreStart, leftPreEnd, inorder, leftInStart, leftInEnd);
        root.right =
                buildTree(preorder, rightPreStart, rightPreEnd, inorder, rightInStart, rightInEnd);
        return root;
    }
}

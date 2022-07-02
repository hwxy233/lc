package com.hwxy.code.leetcode.order.l200.l106;

import java.util.HashMap;
import java.util.Map;

import com.hwxy.code.ds.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 
 * @author hwxy
 * @date 2022/07/02
 **/
public class Lc106Nc {
    private int[] inorder;
    private int[] postorder;
    private Map<Integer, Integer> inIndexMap;

    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null
                || inorder.length != postorder.length) {
            return null;
        }
        this.inorder = inorder;
        this.postorder = postorder;
        inIndexMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inIndexMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return dfs(0, inorder.length - 1);
    }


    private TreeNode dfs(int start, int end) {
        if (start == end) {
            postIndex--;
            return new TreeNode(inorder[start]);
        }
        // 用后续找根,然后用根值从中序切分左右子树,一定要先右后左
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = inIndexMap.get(rootVal);
        // right
        if (rootIndex + 1 <= end) {
            root.right = dfs(rootIndex + 1, end);
        }
        // left
        if (start <= rootIndex - 1) {
            root.left = dfs(start, rootIndex - 1);
        }
        return root;
    }
}

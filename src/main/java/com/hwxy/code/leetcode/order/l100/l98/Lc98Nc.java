package com.hwxy.code.leetcode.order.l100.l98;

import java.util.HashMap;
import java.util.Map;

import com.hwxy.code.ds.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * 
 * @author hwxy
 * @date 2022/07/01
 **/
public class Lc98Nc {

    private Map<TreeNode, Integer> maxRecord;
    private Map<TreeNode, Integer> minRecord;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        maxRecord = new HashMap<>();
        minRecord = new HashMap<>();
        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left) || !dfs(root.right)) {
            return false;
        }
        // 找到左子树的最大值和右子树的最小值,分情况看下null的情况
        if (root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            return root.val < findMin(root.right);
        } else if (root.right == null) {
            return root.val > findMax(root.left);
        }
        int leftMax = findMax(root.left);
        int rightMin = findMin(root.right);
        return root.val > leftMax && root.val < rightMin;
    }

    private int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (minRecord.containsKey(root)) {
            return minRecord.get(root);
        }
        int leftMin = findMin(root.left);
        int rightMin = findMin(root.right);
        int rootMin = Math.min(root.val, Math.min(leftMin, rightMin));
        minRecord.put(root, rootMin);
        return rootMin;
    }

    private int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (maxRecord.containsKey(root)) {
            return maxRecord.get(root);
        }
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        int rootMax = Math.max(root.val, Math.max(leftMax, rightMax));
        maxRecord.put(root, rootMax);
        return rootMax;
    }

}

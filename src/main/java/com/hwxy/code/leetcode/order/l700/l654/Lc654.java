package com.hwxy.code.leetcode.order.l700.l654;

import com.hwxy.code.ds.TreeNode;

/**
 * 654. 最大二叉树
 * https://leetcode.cn/problems/maximum-binary-tree/
 *
 * @author hwxy
 * @date 2022/08/20
 **/
public class Lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int left, int right) {
        if (left < 0 || left > right || right >= nums.length) {
            return null;
        }
        int maxIndex = findMax(nums, left, right);
        TreeNode parent = new TreeNode(nums[maxIndex]);
        parent.left = dfs(nums, left, maxIndex - 1);
        parent.right = dfs(nums, maxIndex + 1, right);
        return parent;
    }

    private int findMax(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int ans = left;
        int max = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ans = i;
            }
        }
        return ans;
    }
}

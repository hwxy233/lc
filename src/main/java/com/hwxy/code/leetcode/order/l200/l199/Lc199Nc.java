package com.hwxy.code.leetcode.order.l200.l199;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hwxy.code.ds.TreeNode;

/**
 * 199.二叉树的右视图
 * https://leetcode-cn.com/problems/binary-tree-right-side-view/
 *
 * @author hwxy
 * @date 2022/07/14
 **/
public class Lc199Nc {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans, 0);
        return ans;
    }

    /**
     * 先序遍历
     * 但是要记录一个depth
     * 因为存在左子树高于右子树的情况所以只有depth==ans.size()时才进行add
     * 
     * @param root
     * @param ans
     * @param depth
     */
    private void dfs(TreeNode root, List<Integer> ans, int depth) {
        if (root == null) {
            return;
        }
        if (ans.size() == depth) {
            ans.add(root.val);
        }
        depth++;
        dfs(root.right, ans, depth);
        dfs(root.left, ans, depth);
    }
}

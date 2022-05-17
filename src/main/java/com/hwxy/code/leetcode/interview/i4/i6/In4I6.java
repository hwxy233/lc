package com.hwxy.code.leetcode.interview.i4.i6;

import java.util.ArrayList;
import java.util.List;

import com.hwxy.code.ds.TreeNode;

/**
 * 面试题 04.06. 后继者
 * https://leetcode.cn/problems/successor-lcci/
 * 
 * @author hwxy
 * @date 2022/05/16
 **/
public class In4I6 {
    private boolean findTarget;
    private List<TreeNode> midRes;

    /**
     * 中序遍历
     * 但是也可以利用bst性质
     * ```code
     * ``` ```public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
     * ``` ``` if (root == null) return null;
     * ``` ``` if (root.val <= p.val) return inorderSuccessor(root.right, p);
     * ``` ``` TreeNode ans = inorderSuccessor(root.left, p);
     * ```code
     * 
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) {
            return null;
        }
        findTarget = false;
        midRes = new ArrayList<>(2);
        dfs(root, p);
        if (midRes.size() != 2) {
            return null;
        }
        return midRes.get(1);
    }

    /**
     * 先序遍历
     * 
     * @param root
     * @param p
     * @return
     */
    private void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (root.val == p.val) {
            findTarget = true;
        }
        if (findTarget && midRes.size() < 2) {
            midRes.add(root);
        }
        dfs(root.right, p);
    }
}

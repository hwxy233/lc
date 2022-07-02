package com.hwxy.code.leetcode.order.l100.l98;

import com.hwxy.code.ds.TreeNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/07/02
 **/
public class Lc98Nc1 {
    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        pre = null;
        return dfs(root);
    }

    /**
     * 中序遍历是有序的,维护一个pre节点代表中序遍历的前一个
     * 要求当前节点肯定是大于pre的
     * 中序的left结束后将当前的root赋值给pre,然后遍历right
     * 
     * @param root
     * @return
     */
    private boolean dfs(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!dfs(root.left)) {
            return false;
        }
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        return dfs(root.right);
    }
}

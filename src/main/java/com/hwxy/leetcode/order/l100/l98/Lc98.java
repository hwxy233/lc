package com.hwxy.leetcode.order.l100.l98;

import com.hwxy.leetcode.type.tree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc98 {
    /**
     * 要记录上一个节点的值
     */
    private TreeNode pre;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }
        return valid(root);
    }

    /**
     * 注意:中序遍历BST是升序的,要记录上一个节点的值,不能单纯比较当前节点的值
     * 
     * 节点的左子树只包含 小于 当前节点的数。
     * 节点的右子树只包含 大于 当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * 
     * @param root
     * @return
     */
    private boolean valid(TreeNode root) {
        // 终止条件
        if (root == null) {
            return true;
        }
        // 左
        boolean leftValid = valid(root.left);
        // 中,整体升序
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        pre = root;
        // 右
        boolean rightValid = valid(root.right);
        return leftValid && rightValid;
    }
}

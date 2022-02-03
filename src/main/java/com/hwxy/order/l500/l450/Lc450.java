package com.hwxy.order.l500.l450;

import com.hwxy.type.tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * https://leetcode-cn.com/problems/delete-node-in-a-bst/
 *
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        return delete(root, key);
    }

    /**
     * 后序遍历
     * 
     * @param root
     * @param key
     * @return 返回删除的根
     */
    private TreeNode delete(TreeNode root, int key) {
        // 终止条件,情况1没有找到
        if (root == null) {
            return root;
        }
        // 找到了
        if (root.val == key) {
            // 情况2,左右孩子都空,直接删除节点
            if (root.left == null && root.right == null) {
                return null;
            }
            // 情况3,左孩子为空,右孩子部位
            else if (root.left == null) {
                return root.right;
            }
            // 情况4,右孩子空,左孩子部位
            else if (root.right == null) {
                return root.left;
            }
            // 情况5,左右都不空,将删除节点的左孩子放到删除节点有孩子的最左子树,返回删除节点的右孩子为根
            else {
                TreeNode cur = root.right;
                while (cur.left != null) {
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (key < root.val) {
            root.left = delete(root.left, key);
        }
        if (key > root.val) {
            root.right = delete(root.right, key);
        }
        return root;
    }
}

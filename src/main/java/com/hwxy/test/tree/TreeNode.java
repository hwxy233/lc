package com.hwxy.test.tree;

/**
 * 树的节点
 */
public class TreeNode {
    public TreeNode(int val) {
        this.val = val;
    }

    int val;
    TreeNode left;
    TreeNode right;

    /**
     * 遍历格式
     *
     * @param root 根节点
     */
    private void traverse(TreeNode root) {
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.right);
        // 后序遍历
    }

    /**
     * 给所有节点的值+1
     *
     * @param root 根
     */
    private void plusOne(TreeNode root) {
        if (root == null) {
            return;
        }
        root.val += 1;
        plusOne(root.left);
        plusOne(root.right);
    }

    /**
     * 判断2棵树一样
     *
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSameTree(TreeNode root1, TreeNode root2) {
        // 都为空的话，显然相同
        if (root1 == null && root2 == null) return true;
        // 一个为空，一个非空，显然不同
        if (root1 == null || root2 == null) return false;
        // 两个都非空，但 val 不一样也不行
        if (root1.val != root2.val) return false;


        // root1 和 root2 该比的都比完了
        return isSameTree(root1.left, root2.left)
                && isSameTree(root1.right, root2.right);
    }

    /**
     * 判断bst
     *
     * @param root
     * @return
     */
    private boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // 这是个前序遍历的方法
        if (root == null) return true;
        if (min != null && root.val <= min.val) return false;
        if (max != null && root.val >= max.val) return false;
        // 在这里遍历左和右,左:max是当前的root,右:min是当前的root
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}





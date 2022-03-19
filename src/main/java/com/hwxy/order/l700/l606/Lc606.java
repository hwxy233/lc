package com.hwxy.order.l700.l606;

/**
 * 606. 根据二叉树创建字符串
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 * 
 * @author hwxy
 * @date 2022/03/19
 **/
public class Lc606 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
                new TreeNode(3, null, null));
        TreeNode root1 = new TreeNode(1, new TreeNode(2, null, new TreeNode(4, null, null)),
                new TreeNode(3, null, null));
        System.out.println(new Lc606().tree2str(root));
    }

    private StringBuilder res;

    public String tree2str(TreeNode root) {
        if (root == null) {
            return null;
        }
        res = new StringBuilder();
        dfs(root);
        return res.toString();
    }

    /**
     * 深度优先搜索
     * 如果当前节点只有右孩子，那我们在递归时，
     * 需要先加上一层空的括号 ‘()’ 表示左孩子为空，
     * 再对右孩子进行递归，并在结果外加上一层括号。
     * 
     * @param root
     */
    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序先拼自己
        res.append(root.val);
        // 拼左
        if (root.left != null) {
            res.append("(");
            dfs(root.left);
            res.append(")");
        } else if (root.right != null) {
            // 左空右不空的话拼一个()
            res.append("()");
        }
        // 拼右
        if (root.right != null) {
            res.append("(");
            dfs(root.right);
            res.append(")");
        }
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

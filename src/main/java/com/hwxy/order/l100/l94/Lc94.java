package com.hwxy.order.l100.l94;

import com.hwxy.type.tree.TreeNode;

import java.util.*;

public class Lc94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(3, null, null)), null);
        Lc94 lc94 = new Lc94();
        System.out.println(lc94.inorderTraversal(root));
    }

    /**
     * 中序遍历
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (Objects.isNull(root)) {
            return Collections.emptyList();
        }
        List<Integer> result = new LinkedList<>();
        doInorderTraversal(root, result);
        return result;
    }

    private void doInorderTraversal(TreeNode root, List<Integer> result) {
        if (Objects.isNull(root)) {
            return;
        }
        doInorderTraversal(root.left, result);
        // 在中间进行add操作
        result.add(root.val);
        doInorderTraversal(root.right, result);
    }
}

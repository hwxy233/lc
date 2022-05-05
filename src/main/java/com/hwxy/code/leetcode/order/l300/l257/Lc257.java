package com.hwxy.code.leetcode.order.l300.l257;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import com.hwxy.ds.TreeNode;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 * 
 * @author hwxy
 * @date 2022/02/02
 **/
public class Lc257 {

    public static void main(String[] args) {
        System.out.println(new Lc257().binaryTreePaths(new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5, null, null)), new TreeNode(3, null, null))));
    }

    private List<List<Integer>> res = new LinkedList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> curRes = new LinkedList<>();
        calPaths(root, curRes);
        List<String> result = new LinkedList<>();
        for (List<Integer> list : res) {
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (Integer point : list) {
                if (i++ == 0) {
                    stringBuilder.append(point);
                } else {
                    stringBuilder.append("->").append(point);
                }
            }
            result.add(stringBuilder.toString());
        }
        return result;
    }

    /**
     * 前序遍历
     * 注意要回溯删除
     * 
     * @param root
     * @param curRes
     */
    private void calPaths(TreeNode root, LinkedList<Integer> curRes) {
        curRes.add(root.val);
        if (root.left == null && root.right == null) {
            // 到叶子节点了返回
            res.add(new LinkedList<>(curRes));
        }
        if (root.left != null) {
            calPaths(root.left, curRes);
        }
        if (root.right != null) {
            calPaths(root.right, curRes);
        }
        curRes.removeLast();
    }
}

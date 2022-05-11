package com.hwxy.code.leetcode.order.l500.l449;

import com.hwxy.code.ds.TreeNode;

/**
 * 449. 序列化和反序列化二叉搜索树
 * https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * 
 * @author hwxy
 * @date 2022/05/11
 **/
public class Lc449 {}


class Codec {
    public static final String SP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        dfsSerialize(sb, root);
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 先序遍历
     * 然后不需要额外编码null
     * 
     * @param sb
     * @param root
     */
    private void dfsSerialize(StringBuilder sb, TreeNode root) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(SP);
        dfsSerialize(sb, root.left);
        dfsSerialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        String[] nodeStrs = data.split(SP);
        return dfsDeserialize(nodeStrs, 0, nodeStrs.length - 1);
    }

    /**
     * left是当前的根,从left+1到right找第一个 > 根的就是右子树
     * 前面的区间就是左子树
     * 
     * @param nodeStrs
     * @param start
     * @param end
     * @return
     */
    private TreeNode dfsDeserialize(String[] nodeStrs, int start, int end) {
        if (start > end) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodeStrs[start]));
        // 找到右子树区间开始
        int rightStart = start + 1;
        // 这里要是<=因为end可以取到
        for (; rightStart <= end; rightStart++) {
            if (Integer.parseInt(nodeStrs[rightStart]) > root.val) {
                break;
            }
        }
        // 前面的就是左子树区间
        root.left = dfsDeserialize(nodeStrs, start + 1, rightStart - 1);
        root.right = dfsDeserialize(nodeStrs, rightStart, end);
        return root;
    }
}

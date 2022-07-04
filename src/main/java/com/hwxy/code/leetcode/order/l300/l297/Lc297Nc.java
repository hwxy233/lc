package com.hwxy.code.leetcode.order.l300.l297;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import com.hwxy.code.ds.TreeNode;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/07/04
 **/
public class Lc297Nc {}


class CodecNc {

    public static final String N = "N";
    public static final String DOT = ",";
    public static final String N_DOT = N + DOT;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return N;
        }
        StringBuilder sb = new StringBuilder();
        dfsSerialize(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void dfsSerialize(StringBuilder sb, TreeNode root) {
        if (root == null) {
            sb.append(N_DOT);
            return;
        }
        sb.append(root.val).append(DOT);
        dfsSerialize(sb, root.left);
        dfsSerialize(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty() || N.equals(data)) {
            return null;
        }
        Queue<String> queue = new ArrayDeque<>(List.of(data.split(DOT)));
        return dfsDeserialize(queue);
    }

    private TreeNode dfsDeserialize(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        String valStr = queue.poll();
        if (N.equals(valStr)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(valStr));
        root.left = dfsDeserialize(queue);
        root.right = dfsDeserialize(queue);
        return root;
    }
}

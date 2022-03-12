package com.hwxy.order.l600.l590;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 590. N 叉树的后序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 * 
 * @author hwxy
 * @date 2022/03/12
 **/
public class Lc590 {
    private List<Integer> res;

    public List<Integer> postorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        res = new LinkedList<>();
        dfs(root);
        return res;
    }

    /**
     * 左....右....根
     * 
     * @param root
     */
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            dfs(child);
        }
        res.add(root.val);
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}

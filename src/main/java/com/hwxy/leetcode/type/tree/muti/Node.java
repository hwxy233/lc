package com.hwxy.leetcode.type.tree.muti;

import java.util.List;

/**
 * 多叉树节点
 *
 * @author hwxy
 * @date 2021/11/20
 **/
public class Node {
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

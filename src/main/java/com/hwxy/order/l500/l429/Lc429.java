package com.hwxy.order.l500.l429;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.hwxy.type.tree.muti.Node;

/**
 * 429. N 叉树的层序遍历
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 *
 * @author hwxy
 * @date 2021/11/20
 **/
public class Lc429 {


    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> re = new LinkedList<>();
        while (!queue.isEmpty()) {
            int childSize = queue.size();
            List<Integer> levelRe = new LinkedList<>();
            // 注意size条件
            for (int i = 0; i < childSize; i++) {
                Node levelRoot = queue.poll();
                levelRe.add(levelRoot.val);
                // if (levelRoot.children == null) {
                // continue;
                // }
                // 反正把孩子都放进去
                for (Node child : levelRoot.children) {
                    // if (child == null) {
                    // continue;
                    // }
                    queue.add(child);
                }
            }
            re.add(levelRe);
        }
        return re;
    }
}

package com.hwxy.code.leetcode.order.l200.l116;


import java.util.LinkedList;
import java.util.Queue;

import com.hwxy.code.ds.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * @author hwxy
 * @date 2021/11/20
 **/
public class Lc116 {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node pre = null;
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                // 先给个null
                cur.next = null;
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                // 非最左的节点都需要指向nxet连接起来
                if (i != 0) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }

}

package com.hwxy.code.leetcode.order.l1300.l1206;

import java.util.LinkedList;
import java.util.Random;

/**
 * 1206. 设计跳表
 * https://leetcode.cn/problems/design-skiplist/
 * https://www.bilibili.com/video/BV1kT4y1F7Nr?spm_id_from=333.337.search-card.all.click&vd_source=ae37b8a39773bf433c9dd1810387008b
 * https://zxi.mytechroad.com/blog/desgin/leetcode-1206-design-skiplist/
 * 
 * @author hwxy
 * @date 2022/07/26
 **/
public class Lc1206 {}


class Skiplist {

    private Node root;

    private final Random random;

    public Skiplist() {
        root = new Node(-1, null, null);
        random = new Random();
    }

    public boolean search(int target) {
        Node node = root;
        // 先从第一次开始向右搜索,如果能找到则结束,否则向右找到最大的小于target的
        // 然后向下找
        while (node != null) {
            // 不断向右直到>=target
            while (node.right != null && node.right.val < target) {
                node = node.right;
            }
            // =则返回
            if (node.right != null && node.right.val == target) {
                return true;
            }
            // >则向下
            node = node.down;
        }
        return false;
    }

    public void add(int num) {
        LinkedList<Node> nodes = new LinkedList<>();
        Node node = root;
        // 先找到所有 <num 的最大值
        while (node != null) {
            while (node.right != null && node.right.val < num) {
                node = node.right;
            }
            nodes.add(node);
            node = node.down;
        }
        // 然后逐个进行插入(插后面),最底层是一定要插入的,上层每增加一层概率减少一半
        boolean insert = true;
        // 是从最底层到最上层保持的
        Node down = null;
        while (insert && !nodes.isEmpty()) {
            // 一定要从后面remove
            node = nodes.removeLast();
            // 注意这里的写法,可以省掉一步
            node.right = new Node(num, node.right, down);
            down = node.right;
            insert = random.nextInt(2) == 0;
        }
        // 最终如果还要insert的话要扩一层
        if (insert) {
            root = new Node(-1, null, root);
        }
    }

    public boolean erase(int num) {
        Node node = root;
        // 先从第一次开始向右搜索,如果能找到则结束,否则向右找到最大的小于target的
        // 然后向下找
        boolean found = false;
        while (node != null) {
            while (node.right != null && node.right.val < num) {
                node = node.right;
            }
            // 注意是删除所以找下一个=的
            if (node.right != null && node.right.val == num) {
                found = true;
                node.right = node.right.right;
            }
            // 这层的删除完了
            node = node.down;
        }
        return found;
    }

    static class Node {
        private final int val;
        /**
         * 向右
         */
        private Node right;
        /**
         * 向下
         */
        private Node down;

        public Node(int val, Node right, Node down) {
            this.val = val;
            this.right = right;
            this.down = down;
        }
    }
}

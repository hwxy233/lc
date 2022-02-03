package com.hwxy.order.l600.l501;

import java.util.ArrayList;
import java.util.List;

import com.hwxy.type.tree.TreeNode;

/**
 * 501. 二叉搜索树中的众数
 * https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc501 {
    private List<Integer> res;
    /**
     * 当前值的频次
     */
    private int curCnt;
    /**
     * 最大频次
     */
    private int maxCnt;
    /**
     * 记录上一个的节点,进行比较
     */
    private TreeNode pre;

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return null;
        }
        res = new ArrayList<>();
        curCnt = 0;
        maxCnt = 0;
        find(root);
        return res.stream().mapToInt(i -> i).toArray();
    }

    /**
     * 中序遍历
     * 用pre指针记录相邻情况
     * 
     * @param root
     */
    private void find(TreeNode root) {
        if (root == null) {
            return;
        }
        find(root.left);
        // 中
        if (pre != null && root.val == pre.val) {
            curCnt++;
        } else {
            curCnt = 1;
        }
        // 如果当前值最大
        if (curCnt > maxCnt) {
            // 清空
            res.clear();
            res.add(root.val);
        }
        // 相等的话就入队
        if (curCnt == maxCnt) {
            res.add(root.val);
        }
        // 更新最大值和pre
        maxCnt = Math.max(curCnt, maxCnt);
        pre = root;
        // 右
        find(root.right);
    }
}

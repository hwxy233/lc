package com.hwxy.code.leetcode.order.l600.l530;

import java.util.ArrayList;
import java.util.List;

import com.hwxy.ds.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/
 * 
 * @author hwxy
 * @date 2022/02/03
 **/
public class Lc530 {
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        // 转数组后计算相邻的差的绝对值
        List<Integer> valList = new ArrayList<>();
        travelMiddle(root, valList);
        int sumMin = Integer.MAX_VALUE;;
        if (valList.size() < 2) {
            return sumMin;
        }
        int pre = valList.get(0);
        for (int i = 1; i < valList.size(); i++) {
            sumMin = Math.min(sumMin, Math.abs(valList.get(i) - pre));
            pre = valList.get(i);
        }
        return sumMin;
    }

    /**
     * 中序遍历BST转为数组
     * 中序的值为升序
     * 
     * @param root
     * @param valList
     */
    private void travelMiddle(TreeNode root, List<Integer> valList) {
        if (root == null) {
            return;
        }
        travelMiddle(root.left, valList);
        valList.add(root.val);
        travelMiddle(root.right, valList);
    }
}

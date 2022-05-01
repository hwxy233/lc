package com.hwxy.leetcode.order.l1400.l1305;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1305. 两棵二叉搜索树中的所有元素
 * https://leetcode-cn.com/problems/all-elements-in-two-binary-search-trees/
 * 
 * @author hwxy
 * @date 2022/05/01
 **/
public class Lc1305 {
    /**
     * 分别中序遍历获得有序的元素集合
     * 然后归并排序2个集合的元素
     * 
     * @param root1
     * @param root2
     * @return
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return Collections.emptyList();
        }
        List<Integer> sortedList1 = new ArrayList<>();
        List<Integer> sortedList2 = new ArrayList<>();
        dfs(root1, sortedList1);
        dfs(root2, sortedList2);
        List<Integer> res = mergeSorted(sortedList1, sortedList2);
        return res;
    }

    /**
     * 归并排序
     * 
     * @param sortedList1
     * @param sortedList2
     * @return
     */
    private List<Integer> mergeSorted(List<Integer> sortedList1, List<Integer> sortedList2) {
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>(sortedList1.size() + sortedList2.size());
        while (i < sortedList1.size() && j < sortedList2.size()) {
            while (i < sortedList1.size() && sortedList1.get(i) <= sortedList2.get(j)) {
                res.add(sortedList1.get(i));
                i++;
            }
            // 这里记得卡一下i
            while (i < sortedList1.size() && j < sortedList2.size()
                    && sortedList2.get(j) <= sortedList1.get(i)) {
                res.add(sortedList2.get(j));
                j++;
            }
        }
        // 这2个只能执行一个
        while (i < sortedList1.size()) {
            res.add(sortedList1.get(i));
            i++;
        }
        while (j < sortedList2.size()) {
            res.add(sortedList2.get(j));
            j++;
        }
        // 剩余的元素
        return res;
    }

    private void dfs(TreeNode root, List<Integer> sortedList) {
        if (root == null) {
            return;
        }
        dfs(root.left, sortedList);
        sortedList.add(root.val);
        dfs(root.right, sortedList);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

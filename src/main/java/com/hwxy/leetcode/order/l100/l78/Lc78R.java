package com.hwxy.leetcode.order.l100.l78;

import java.util.LinkedList;
import java.util.List;

/**
 * 78复习
 *
 * @author hwxy
 * @date 2021/10/02
 **/
public class Lc78R {
    public static void main(String[] args) {
        Lc78R lc78R = new Lc78R();
        System.out.println(lc78R.subsets(new int[] {1, 2, 3}));
    }

    private LinkedList<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int index) {
        res.add(new LinkedList<>(path));
        if (index == nums.length) {
            return;
        }
        // 重复取,从0开始;不重复取从index开始
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.removeLast();
        }
    }
}

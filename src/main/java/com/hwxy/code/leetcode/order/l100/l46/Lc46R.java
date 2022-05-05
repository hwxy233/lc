package com.hwxy.code.leetcode.order.l100.l46;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/10/03
 **/
public class Lc46R {

    public static void main(String[] args) {
        Lc46R lc46R = new Lc46R();
        System.out.println(lc46R.permute(new int[] {1, 2, 3}));
    }

    private LinkedList<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (nums.length == path.size()) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            used[i] = false;
            path.removeLast();
        }
    }
}

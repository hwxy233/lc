package com.hwxy.leetcode.order.l100.l47;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2021/10/03
 **/
public class Lc47R {

    public static void main(String[] args) {
        Lc47R lc47R = new Lc47R();
        System.out.println(lc47R.permuteUnique(new int[] {1, 1, 2}));
    }

    private LinkedList<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new LinkedList<>(path));
            return;
        }
        // 排列从0开始
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            // 排序过了所以可以这么去重
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
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

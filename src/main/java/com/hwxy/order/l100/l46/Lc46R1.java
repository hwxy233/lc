package com.hwxy.order.l100.l46;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc46R1 {
    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> curRes = new LinkedList<>();

    private int[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new int[nums.length];
        Arrays.fill(used, 0);
        backtracking(nums);
        return res;
    }

    private void backtracking(int[] nums) {
        if (curRes.size() == nums.length) {
            res.add(new LinkedList<>(curRes));
            return;
        }
        // 排列从0开始,并且要去重
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            curRes.add(nums[i]);
            used[i] = 1;
            backtracking(nums);
            used[i] = 0;
            curRes.removeLast();
        }
    }
}

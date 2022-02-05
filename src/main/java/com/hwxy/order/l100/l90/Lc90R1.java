package com.hwxy.order.l100.l90;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc90R1 {
    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> curRes = new LinkedList<>();

    private int[] used;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new int[nums.length];
        Arrays.fill(used, 0);
        Arrays.sort(nums);
        backtracking(nums, 0);
        res.add(Collections.emptyList());
        return res;
    }

    private void backtracking(int[] nums, int start) {
        if (!curRes.isEmpty()) {
            res.add(new LinkedList<>(curRes));
        }
        for (int i = start; i < nums.length; i++) {
            // 树层去重
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                continue;
            }
            curRes.add(nums[i]);
            used[i] = 1;
            backtracking(nums, i + 1);
            used[i] = 0;
            curRes.removeLast();
        }
    }
}

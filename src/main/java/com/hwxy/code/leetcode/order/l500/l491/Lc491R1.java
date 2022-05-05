package com.hwxy.code.leetcode.order.l500.l491;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc491R1 {
    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> curRes = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return res;
        }
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int start) {
        if (curRes.size() > 1) {
            res.add(new LinkedList<>(curRes));
        }
        Set<Integer> usedSet = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 要递增,并且本层不能用过
            if ((!curRes.isEmpty() && curRes.getLast() > nums[i]) || usedSet.contains(nums[i])) {
                continue;
            }
            curRes.add(nums[i]);
            usedSet.add(nums[i]);
            backtracking(nums, i + 1);
            curRes.removeLast();
        }
    }
}

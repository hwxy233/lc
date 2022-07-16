package com.hwxy.code.leetcode.order.l100.l46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/
 *
 * @author hwxy
 * @date 2022/07/14
 **/
public class Lc46Nc {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        int[] used = new int[nums.length];
        backtracking(nums, used, ans, new LinkedList<>());
        return ans;
    }

    /**
     * 回溯,每次都从0开始,需要一个used来去重
     * 
     * @param nums
     * @param used
     * @param ans
     * @param tmp
     */
    private void backtracking(int[] nums, int[] used, List<List<Integer>> ans,
            LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == 1) {
                continue;
            }
            tmp.add(nums[i]);
            used[i] = 1;
            backtracking(nums, used, ans, tmp);
            used[i] = 0;
            tmp.removeLast();
        }
    }
}

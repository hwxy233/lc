package com.hwxy.code.leetcode.order.l100.l78;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/
 *
 * @author hwxy
 * @date 2022/07/14
 **/
public class Lc78Nc {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new LinkedList<>();
        backtracking(nums, 0, ans, new LinkedList<>());
        return ans;
    }

    /**
     * 回溯,放在最上面收集
     * 
     * @param nums
     * @param index
     * @param ans
     * @param tmp
     */
    private void backtracking(int[] nums, int index, List<List<Integer>> ans,
            LinkedList<Integer> tmp) {
        // 放在最上面每个集合都要收集
        ans.add(new LinkedList<>(tmp));
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtracking(nums, i + 1, ans, tmp);
            tmp.removeLast();
        }
    }
}

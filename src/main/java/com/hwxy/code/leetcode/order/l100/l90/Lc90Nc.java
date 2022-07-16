package com.hwxy.code.leetcode.order.l100.l90;

import java.util.*;

/**
 * 90. 子集 II
 * https://leetcode.cn/problems/subsets-ii/
 *
 * @author hwxy
 * @date 2022/07/14
 **/
public class Lc90Nc {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        backtracking(nums, 0, used, ans, new LinkedList<>());
        return ans;
    }

    /**
     * 回溯,树层去重
     * 
     * @param nums
     * @param index
     * @param used
     * @param ans
     * @param tmp
     */
    private void backtracking(int[] nums, int index, int[] used,
            List<List<Integer>> ans,
            LinkedList<Integer> tmp) {
        // 收集结果
        ans.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            // 同一层去重,实际上可以直接return因为后面都是前面遍历过的,不需要continue
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == 0) {
                return;
            }
            tmp.add(nums[i]);
            used[i] = 1;
            backtracking(nums, i + 1, used, ans, tmp);
            used[i] = 0;
            tmp.removeLast();
        }
    }
}

package com.hwxy.code.leetcode.order.l100.l39;

import java.util.*;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/07/11
 **/
public class Lc39Nc {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        List<List<Integer>> ans = new ArrayList<>();
        // 可以剪枝一些sum过大的情况
        Arrays.sort(candidates);
        backtracking(candidates, 0, target, ans, 0, new LinkedList<Integer>());
        return ans;
    }

    private void backtracking(int[] candidates, int index, int target, List<List<Integer>> ans,
            int sum, LinkedList<Integer> tmp) {
        // 每次都从index开始遍历
        for (int i = index; i < candidates.length && (sum + candidates[i] <= target); i++) {
            tmp.add(candidates[i]);
            sum += candidates[i];
            if (sum == target) {
                ans.add(new ArrayList<>(tmp));
            }
            // 这里每次从当前位置开始,多次获取
            backtracking(candidates, i, target, ans, sum, tmp);
            sum -= candidates[i];
            tmp.removeLast();
        }
    }
}

package com.hwxy.code.leetcode.order.l100.l39;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 39. 组合总和
 * https://leetcode.cn/problems/combination-sum/
 * 
 * @author hwxy
 * @date 2021/07/17
 **/
public class Lc39 {

    private final List<List<Integer>> result = new LinkedList<>();

    private final LinkedList<Integer> tmp = new LinkedList<>();

    public static void main(String[] args) {
        Lc39 lc39 = new Lc39();
        System.out.println(lc39.combinationSum(new int[] {2, 3, 5}, 8));
    }

    /**
     * 
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (Objects.isNull(candidates) || candidates.length == 0 || target <= 0) {
            return result;
        }
        Arrays.sort(candidates);
        backtracking(candidates, 0, 0, target);
        return result;

    }

    /**
     * 不断的从头开始加直到sum >= target
     * 
     * @param candidates
     * @param index
     * @param sum
     * @param target
     */
    private void backtracking(int[] candidates, int index, int sum, int target) {
        if (sum > target) {
            return;
        } else if (sum == target) {
            result.add(new LinkedList<>(tmp));
            return;
        }
        // 传i,如果sum + candidates[i] <= target这样剪枝的话要进行排序
        for (int i = index; i < candidates.length && sum + candidates[i] <= target; i++) {
            tmp.add(candidates[i]);
            // 这里传i,表示重复取数,上面的i++看见了吗,他控制数组的前进
            backtracking(candidates, i, sum + candidates[i], target);
            // 回退
            tmp.removeLast();
        }
    }
}

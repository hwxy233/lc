package com.hwxy.order.l100.l39;

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
public class Lc39R {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> curRes = new LinkedList<>();
    private int leftSum;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.emptyList();
        }
        leftSum = target;
        Arrays.sort(candidates);
        backtracking(candidates, 0);
        return res;
    }

    private void backtracking(int[] candidates, int startIndex) {
        if (leftSum == 0) {
            res.add(new LinkedList<>(curRes));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 排好序的,可以剪掉大的
            if (leftSum < candidates[i]) {
                return;
            }
            curRes.add(candidates[i]);
            leftSum -= candidates[i];
            // 我发现这里总是可能写错是i写成startIndex
            backtracking(candidates, i);
            leftSum += candidates[i];
            curRes.removeLast();
        }
    }
}

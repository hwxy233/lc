package com.hwxy.leetcode.order.l100.l40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc40R1 {
    private List<List<Integer>> res = new LinkedList<>();

    private LinkedList<Integer> curRes = new LinkedList<>();

    private int leftSum;

    private int[] used;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        leftSum = target;
        used = new int[candidates.length];
        Arrays.fill(used, 0);
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
            // 剪掉大的
            if (leftSum < candidates[i]) {
                return;
            }
            // 这里进行下横向(树层)去重,used[i - 1] == 0说明上一个用的是和自己相同的值
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == 0) {
                continue;
            }
            curRes.add(candidates[i]);
            leftSum -= candidates[i];
            used[i] = 1;
            backtracking(candidates, i + 1);
            used[i] = 0;
            leftSum += candidates[i];
            curRes.removeLast();
        }
    }
}

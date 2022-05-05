package com.hwxy.code.leetcode.order.l100.l40;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40复习
 *
 * @author hwxy
 * @date 2021/10/02
 **/
public class Lc40R {

    public static void main(String[] args) {
        Lc40R lc40R = new Lc40R();
        System.out.println(lc40R.combinationSum2(new int[] {2, 5, 2, 1, 2}, 5));
    }

    private LinkedList<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    private int sum = 0;

    private int[] d;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0 || target <= 0) {
            return result;
        }
        Arrays.sort(candidates);
        d = new int[candidates.length + 1];
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int index) {
        if (sum == target) {
            result.add(new LinkedList<>(path));
            return;
        }
        if (sum > target) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            d[i] = 1;
            if (i > 0 && candidates[i] == candidates[i - 1]
                    && d[i] == 1
                    && d[i - 1] == 0) {
                d[i] = 0;
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            path.removeLast();
            d[i] = 0;
        }
    }
}

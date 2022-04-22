package com.hwxy.leetcode.order.l300.l216;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc216R1 {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> curRes = new LinkedList<>();
    private int leftSum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k <= 0 || n <= 0) {
            return res;
        }
        leftSum = n;
        backtracking(1, k, n);
        return res;
    }

    private void backtracking(int startIndex, int k, int n) {
        if (curRes.size() == k) {
            if (leftSum == 0) {
                res.add(new LinkedList<>(curRes));
            }
            return;
        }
        // 剩余的和要大于剩余当前数字 && 还需要数量 <= 剩余可选数量
        for (int i = startIndex; leftSum >= i && (k - curRes.size() <= 9 - i + 1); i++) {
            curRes.add(i);
            leftSum -= i;
            backtracking(i + 1, k, n);
            leftSum += i;
            curRes.removeLast();
        }
    }
}

package com.hwxy.leetcode.order.l300.l216;

import java.util.LinkedList;
import java.util.List;

/**
 * 216复习
 *
 * @author hwxy
 * @date 2021/10/01
 **/
public class Lc216R {

    public static void main(String[] args) {
        Lc216R lc216R = new Lc216R();
        System.out.println(lc216R.combinationSum3(9, 3));
    }

    private LinkedList<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> path = new LinkedList<>();

    private int sum;

    public List<List<Integer>> combinationSum3(int n, int k) {
        if (n <= 0 || k <= 0) {
            return result;
        }
        backtracking(n, k, 1);
        return result;
    }

    private void backtracking(int n, int k, int index) {
        if (sum > n) {
            return;
        }
        if (path.size() == k) {
            if (sum == n) {
                result.add(new LinkedList<>(path));
            }
            return;
        }
        for (int i = index; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(n, k, i + 1);
            path.removeLast();
            sum -= i;
        }
    }
}

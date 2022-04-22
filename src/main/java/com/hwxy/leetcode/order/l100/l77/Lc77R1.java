package com.hwxy.leetcode.order.l100.l77;

import java.util.LinkedList;
import java.util.List;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/02/04
 **/
public class Lc77R1 {
    public static void main(String[] args) {
        System.out.println(new Lc77R1().combine(4, 2));
    }

    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> curRes = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n < 0 || k < 0) {
            return res;
        }
        backtracking(1, n, k);
        return res;
    }

    private void backtracking(int cur, int n, int k) {
        if (curRes.size() == k) {
            res.add(new LinkedList<>(curRes));
            return;
        }
        // 不需要,下面的for条件会判断
        // if (cur > n) {
        // return;
        // }
        // 剩余数量 >= 还需要数量
        for (int i = cur; n - i + 1 >= k - curRes.size(); i++) {
            curRes.add(i);
            backtracking(i + 1, n, k);
            curRes.removeLast();
        }
    }
}

package com.hwxy.order.l100.l77;

import java.util.LinkedList;
import java.util.List;

/**
 * 复习
 *
 * @author hwxy
 * @date 2021/10/01
 **/
public class Lc77R {

    public static void main(String[] args) {
        Lc77R lc77R = new Lc77R();
        System.out.println(lc77R.combine(4, 2));
    }

    private LinkedList<List<Integer>> result = new LinkedList<>();

    private LinkedList<Integer> tmp = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0) {
            return result;
        }

        reverse(n, 1, k);
        return result;
    }

    private void reverse(int n, int index, int k) {
        if (tmp.size() == k) {
            result.add(new LinkedList<>(tmp));
            return;
        }
        if (index > n) {
            return;
        }
        for (int i = index; i <= n - (k - tmp.size()) + 1; i++) {
            tmp.add(i);
            reverse(n, i + 1, k);
            tmp.removeLast();
        }
    }
}

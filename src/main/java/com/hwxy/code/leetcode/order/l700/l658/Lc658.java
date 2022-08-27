package com.hwxy.code.leetcode.order.l700.l658;

import java.util.*;

/**
 * 658. 找到 K 个最接近的元素
 * https://leetcode.cn/problems/find-k-closest-elements/
 *
 * @author hwxy
 * @date 2022/08/25
 **/
public class Lc658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if (arr == null || arr.length == 0 || k < 1) {
            return Collections.emptyList();
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                int absCp = Integer.compare(o1.abs, o2.abs);
                if (absCp != 0) {
                    return absCp;
                }
                return Integer.compare(o1.value, o2.value);
            }
        });
        for (int a : arr) {
            queue.offer(new Pair(Math.abs(a - x), a));
        }
        List<Integer> ans = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            ans.add(queue.poll().value);
        }
        Collections.sort(ans);
        return ans;
    }

    static class Pair {
        int abs;
        int value;

        public Pair(int abs, int value) {
            this.abs = abs;
            this.value = value;
        }
    }
}

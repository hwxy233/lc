package com.hwxy.code.leetcode.interview.in17.i9;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 面试题 17.09. 第 k 个数
 * https://leetcode.cn/problems/get-kth-magic-number-lcci/
 *
 * @author hwxy
 * @date 2022/09/28
 **/
public class In17I9 {
    public static final int[] EL = new int[] {3, 5, 7};

    public int getKthMagicNumber(int k) {
        if (k < 1) {
            return 0;
        }
        // 优先级队列,每次选最小的进行乘3,5,7
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        Set<Long> saved = new HashSet<>();
        priorityQueue.offer(1L);
        saved.add(1L);
        long ans = 1;
        for (int i = 0; i < k; i++) {
            ans = priorityQueue.poll();
            for (int e : EL) {
                long n = ans * e;
                if (saved.add(n)) {
                    priorityQueue.offer(n);
                }
            }
        }
        return (int) ans;
    }
}

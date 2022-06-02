package com.hwxy.code.leetcode.order.l500.l473;

import java.util.Arrays;

/**
 * 473. 火柴拼正方形
 * https://leetcode.cn/problems/matchsticks-to-square/
 *
 * @author hwxy
 * @date 2022/06/01
 **/
public class Lc473 {
    private int[] edges;
    private int midSum;

    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        midSum = 0;
        for (int stick : matchsticks) {
            midSum += stick;
        }
        if (midSum % 4 != 0) {
            return false;
        }
        Arrays.sort(matchsticks);
        // 模拟4条边
        edges = new int[4];
        midSum /= 4;
        return backtracking(matchsticks, matchsticks.length - 1);
    }

    /**
     * index是火柴的index
     * 一定要从大到小排
     * 
     * @param matchsticks
     * @param index
     * @return
     */
    private boolean backtracking(int[] matchsticks, int index) {
        // 说明所有火柴都放好了
        if (index == -1) {
            return true;
        }
        // 将每个火柴逐个放到edge中
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            // 当前的边长够了(火柴可以放到edge) && 下一根火柴也能放到正确的位置
            if (edges[i] <= midSum && backtracking(matchsticks, index - 1)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }

}

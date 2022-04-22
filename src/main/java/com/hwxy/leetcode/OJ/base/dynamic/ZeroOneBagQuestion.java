package com.hwxy.leetcode.OJ.base.dynamic;

import java.util.Objects;

/**
 * 0,1背包问题
 * dfs
 *
 * @author hwxy
 * @date 2021/04/02
 **/
public class ZeroOneBagQuestion {
    public static void main(String[] args) {
        System.out.println(maxBagValue(4, new int[]{2, 1, 3, 2}, new int[]{3, 2, 4, 2}, 5));
    }

    private static int N;
    private static int[] W;
    private static int[] V;

    /**
     * 用小于等于最大重量获取最大的价值
     *
     * @param n 物品数量
     * @param w 重量
     * @param v 价值
     * @return 总价值
     */
    public static int maxBagValue(int n, int[] w, int[] v, int maxW) {
        if (n <= 0 || maxW <= 0 || Objects.isNull(w) || Objects.isNull(v) || w.length != v.length || w.length != n) {
            return 0;
        }
        N = n;
        W = w;
        V = v;
        return maxBagValue(0, maxW);
    }

    /**
     * 递归(深度优先搜索)
     *
     * @param lessWeight 剩余数量
     * @param i          第几个物品了
     * @return 总价值, 每次是要(不要)累加的当前物品的价值
     */
    private static int maxBagValue(int i, int lessWeight) {
        if (i == N) {
            return 0;
        }
        // 重量超了就跳过
        if (W[i] > lessWeight) {
            return maxBagValue(i + 1, lessWeight);
        } else {
            // 加和不加的最大值
            return Math.max(
                    V[i] + maxBagValue(i + 1, lessWeight - W[i]),
                    maxBagValue(i + 1, lessWeight));
        }
    }
}

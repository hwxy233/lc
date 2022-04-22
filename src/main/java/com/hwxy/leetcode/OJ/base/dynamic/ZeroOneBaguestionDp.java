package com.hwxy.leetcode.OJ.base.dynamic;

import java.util.Objects;

/**
 * 0,1背包问题
 * dfs + dp
 *
 * @author hwxy
 * @date 2021/04/02
 **/
public class ZeroOneBaguestionDp {
    public static void main(String[] args) {
        System.out.println(maxBagValue(4, new int[]{2, 1, 3, 2}, new int[]{3, 2, 4, 2}, 5));
    }

    private static int N;
    private static int[] W;
    private static int[] V;
    /**
     * 记忆数组
     * 一共有物品数 * 重量种组合
     */
    private static int[][] DP;

    /**
     * 用小于等于最大重量获取最大的价值
     *
     * @param n 物品数量
     * @param w 重量
     * @param v 价值
     * @return 总价值
     */
    public static int maxBagValue(int n, int[] w, int[] v, int maxW) {
        if (n <= 0 || maxW <= 0 ||
                Objects.isNull(w) ||
                Objects.isNull(v) ||
                w.length != v.length ||
                w.length != n) {
            return 0;
        }
        N = n;
        W = w;
        V = v;
        // 初始化记忆数组, +1为了防止i == n的时候越界
        DP = new int[N + 1][maxW + 1];
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                DP[i][j] = -1;
            }
        }
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
        if (DP[i][lessWeight] >= 0) {
            return DP[i][lessWeight];
        }
        int sumValue = 0;
        if (i == N) {
            return sumValue;
        }
        // 重量超了就跳过
        if (W[i] > lessWeight) {
            sumValue = maxBagValue(i + 1, lessWeight);
        } else {
            // 加和不加的最大值
            sumValue = Math.max(
                    V[i] + maxBagValue(i + 1, lessWeight - W[i]),
                    maxBagValue(i + 1, lessWeight));
        }
        return DP[i][lessWeight] = sumValue;
    }
}

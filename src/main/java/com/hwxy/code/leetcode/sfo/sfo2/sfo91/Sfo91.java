package com.hwxy.code.leetcode.sfo.sfo2.sfo91;

/**
 * 剑指 Offer II 091. 粉刷房子
 * https://leetcode.cn/problems/JEj789/
 * 
 * @author hwxy
 * @date 2022/06/25
 **/
public class Sfo91 {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        // 第i个位置用3种颜色的最小cost
        int[][] dp = new int[costs.length][3];
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];
        // 分别计算各种颜色的最小值=前面2种的最小值+当前这种颜色的cost
        for (int i = 1; i < costs.length; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }
        return Math.min(dp[dp.length - 1][0], Math.min(dp[dp.length - 1][1], dp[dp.length - 1][2]));
    }
}

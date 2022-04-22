package com.hwxy.leetcode.order.l800.l746;

/**
 * 746. 使用最小花费爬楼梯
 * https://leetcode-cn.com/problems/min-cost-climbing-stairs/
 * 
 * @author hwxy
 * @date 2022/02/06
 **/
public class Lc746 {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        // 确定dp和i,dp[i]代表到达第i层的最少花费sum
        // 确定公式 dp[i] = dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i -2])
        // 最终目标其实是i+1(数组长度)层
        // 到倒数第一层的花费加上那层的花费与倒数第二层比较
        int[] dp = new int[cost.length + 1];
        // 初始值,可以从0或1层开始所以不需要花费
        dp[0] = 0;
        dp[1] = 0;
        // 顺序:郑旭
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[cost.length];
    }
}

package com.hwxy.leetcode.order.l100.l70;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 
 * @author hwxy
 * @date 2022/02/05
 **/
public class Lc70 {
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }
        // dp i,爬到第i层的方法数量
        // 公式dp[i] = dp[i-1] + dp[i-2],倒数第一层上一层楼梯+倒数第二层上2层楼梯
        // 初始化
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        // 顺序:正序
        // 举例
        // 1 2 3 4 5 6
        // 1 2 3 5 8 13
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

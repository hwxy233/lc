package com.hwxy.order.l600.l509;

/**
 * 509. 斐波那契数
 * https://leetcode-cn.com/problems/fibonacci-number/
 * 
 * @author hwxy
 * @date 2022/02/05
 **/
public class Lc509 {
    public int fib(int n) {
        // 边界
        if (n < 2) {
            return n;
        }
        // dp和i
        int[] dp = new int[n + 1];
        // 公式 dp[i] = dp[i-2] + dp[i-1]
        // 初始化
        dp[0] = 0;
        dp[1] = 1;
        // 遍历顺序: 前到后
        // 举例
        // 0 1 2 3 4 5 6
        // 0 1 1 2 3 5 8
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}

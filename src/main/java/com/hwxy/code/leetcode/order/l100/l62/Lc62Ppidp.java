package com.hwxy.code.leetcode.order.l100.l62;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/06/01
 **/
public class Lc62Ppidp {
    public int uniquePaths(int m, int n) {
        if (m < 1 || n < 1) {
            return 0;
        }
        // dp[i][j]为到达(i,j)的路径数
        int[][] dp = new int[m][n];
        // dp[0][0]为1
        dp[0][0] = 1;
        // 对于移动方向来说,dp[i][j]=dp[i-1][j]+dp[i][j-1]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                // 横着走只能
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}

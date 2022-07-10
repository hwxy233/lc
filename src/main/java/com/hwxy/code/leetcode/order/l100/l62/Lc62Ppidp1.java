package com.hwxy.code.leetcode.order.l100.l62;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/07/10
 **/
public class Lc62Ppidp1 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        // dp[i][j]为达到(i,j)的数量
        // 下或右,dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        // 如果 obstacleGrid[i][j] == 1,dp[i][j] = 1
        // 初始 dp[0][j] = 1或0(遇到障碍),dp[i][0] = 1或0
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 1; i < dp.length; i++) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }
        for (int j = 1; j < dp[0].length; j++) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}

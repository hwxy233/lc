package com.hwxy.code.leetcode.order.l100.l63;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/06/01
 **/
public class Lc63Ppidp {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null ||
                obstacleGrid.length == 0 ||
                obstacleGrid[0].length == 0
                || obstacleGrid[0][0] == 1) {
            return 0;
        }
        // dp[i][j] = dp[i][j - 1] + dp[i - 1][j],与62相同只是石头当做0
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 初始为1种方法
        dp[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                // 如果是石头就直接下一个格子,到石头的方法为0
                if (i == 0 && j == 0 || obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i == 0) {
                    dp[i][j] = dp[i][j - 1];
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}

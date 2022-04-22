package com.hwxy.leetcode.order.l100.l63;

/**
 * 63. 不同路径 II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * 
 * @author hwxy
 * @date 2022/02/13
 **/
public class Lc63 {
    public static void main(String[] args) {
        System.out.println(
                new Lc63().uniquePathsWithObstacles(new int[][] {
                        {0, 0, 0},
                        {0, 1, 0},
                        {0, 0, 0}}));
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid[0][0] == 1) {
            return 0;
        }
        // return f1(obstacleGrid);
        return f2(obstacleGrid);
    }

    /**
     * dp
     * 同62题,注意边界和障碍物continue
     * 
     * @param obstacleGrid
     * @return
     */
    private int f2(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        dp[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                // 障碍物是0
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i - 1 >= 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 >= 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        // 最终解果
        return dp[dp.length - 1][dp[0].length - 1];
    }

    /**
     * dfs
     * 
     * @param obstacleGrid
     * @return
     */
    private int f1(int[][] obstacleGrid) {
        return dfs(obstacleGrid, 0, 0);
    }

    private int dfs(int[][] obstacleGrid, int line, int column) {
        // 越界(注意=) || 遇到障碍物
        if (line >= obstacleGrid.length || column >= obstacleGrid[0].length
                || obstacleGrid[line][column] == 1) {
            return 0;
        }
        // 终点
        if (line == obstacleGrid.length - 1 && column == obstacleGrid[0].length - 1) {
            return 1;
        }
        return dfs(obstacleGrid, line + 1, column) + dfs(obstacleGrid, line, column + 1);
    }
}

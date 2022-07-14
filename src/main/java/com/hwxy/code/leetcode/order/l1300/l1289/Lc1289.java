package com.hwxy.code.leetcode.order.l1300.l1289;

/**
 * 1289. 下降路径最小和 II
 * https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/r8oh2h/
 * 
 * @author hwxy
 * @date 2022/07/13
 **/
public class Lc1289 {
    public int minFallingPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return Integer.MAX_VALUE;
        }
        int lineSize = grid.length;
        int columnSize = grid[0].length;
        // 到(i,j)的最小路径和,一行就足够了实际上用不到前一行的数据
        int[][] dp = new int[1][columnSize];
        // 记录前一行的最小和次小值以及对应的列
        int min = Integer.MAX_VALUE;
        int minColumn = -1;
        int nextMin = Integer.MAX_VALUE;
        for (int j = 0; j < columnSize; j++) {
            dp[0][j] = grid[0][j];
            if (grid[0][j] < min) {
                nextMin = min;
                min = grid[0][j];
                minColumn = j;
            } else if (grid[0][j] < nextMin) {
                nextMin = grid[0][j];
            }
        }
        // 要记录一个当前行的最小和以及次小和,对应的列对之前的结果做替换
        // dp[0][j] = min or nextMin + grid[i][j]
        for (int i = 1; i < lineSize; i++) {
            // 记录本行的和与之前做替换
            int curMin = Integer.MAX_VALUE;
            int curMinColumn = -1;
            int curNextMin = Integer.MAX_VALUE;
            for (int j = 0; j < columnSize; j++) {
                if (j != minColumn) {
                    dp[0][j] = grid[i][j] + min;
                } else {
                    dp[0][j] = grid[i][j] + nextMin;
                }
                if (dp[0][j] < curMin) {
                    curNextMin = curMin;
                    curMin = dp[0][j];
                    curMinColumn = j;
                } else if (dp[0][j] < curNextMin) {
                    curNextMin = dp[0][j];
                }
            }
            min = curMin;
            minColumn = curMinColumn;
            nextMin = curNextMin;
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < columnSize; j++) {
            ans = Math.min(ans, dp[0][j]);
        }
        return ans;
    }
}

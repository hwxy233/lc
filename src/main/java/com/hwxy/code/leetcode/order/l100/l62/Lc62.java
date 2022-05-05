package com.hwxy.code.leetcode.order.l100.l62;

/**
 * 62. 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * 
 * @author hwxy
 * @date 2022/02/13
 **/
public class Lc62 {
    public static void main(String[] args) {
        System.out.println(new Lc62().f1(3, 7));
    }

    private int res;

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        // return f1(m, n);
        return f2(m, n);
    }

    /**
     * dp
     * 1. dp[i][j]代表到达(i,j)时的方法数
     * 2. dp[i][j] = dp[i-1][j] + dp[i][j-1]
     * 因为只能从左边或上边到达,所以就是2边的数量
     * 3. dp[1][1] = 1,初始位置一种方法,从(1,1)开始
     * 4. 郑旭遍历
     * 5. test
     * 
     * @param m
     * @param n
     * @return
     */
    private int f2(int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i - 1 > 0) {
                    dp[i][j] += dp[i - 1][j];
                }
                if (j - 1 > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
            }
        }
        // 最终解果
        return dp[m][n];
    }

    /**
     * dfs
     * 
     * @param m
     * @param n
     * @return
     */
    private int f1(int m, int n) {
        res = 0;
        dfs(1, 1, m, n);
        return res;
    }

    private void dfs(int line, int column, int m, int n) {
        // 超过范围
        if (line > m || column > n) {
            return;
        }
        // 到达了终点
        if (line == m && column == n) {
            res++;
            return;
        }
        // 向下
        dfs(line + 1, column, m, n);
        // 向右
        dfs(line, column + 1, m, n);
    }
}

package com.hwxy.code.leetcode.order.l1000.l931;

/**
 * 931. 下降路径最小和
 * https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/r85adr/
 * 
 * @author hwxy
 * @date 2022/07/13
 **/
public class Lc931 {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return Integer.MAX_VALUE;
        }
        int lineSize = matrix.length;
        int columnSize = matrix[0].length;
        // 第一行开始到(i,j)位置的和的最小值,最后返回最后一行的最小值
        // 只是用前一行和当前行的数据,所以可以用压缩数组存储
        int[][] dp = new int[2][columnSize];
        // 第一行是原数组的第一行1
        for (int j = 0; j < columnSize; j++) {
            dp[0][j] = matrix[0][j];
        }
        // dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1], dp[i - 1][j + 1]) + matrix[i][j]
        for (int i = 1; i < lineSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                int preLine = (i - 1) & 1;
                int line = i & 1;
                dp[line][j] = dp[preLine][j];
                if (j != 0) {
                    dp[line][j] = Math.min(dp[line][j], dp[preLine][j - 1]);
                }
                if (j != columnSize - 1) {
                    dp[line][j] = Math.min(dp[line][j], dp[preLine][j + 1]);
                }
                dp[line][j] += matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        int lastLine = (columnSize - 1) & 1;
        for (int j = 0; j < columnSize; j++) {
            ans = Math.min(ans, dp[lastLine][j]);
        }
        return ans;
    }
}

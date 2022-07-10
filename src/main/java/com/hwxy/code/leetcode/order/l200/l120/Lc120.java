package com.hwxy.code.leetcode.order.l200.l120;

import java.util.List;

/**
 * 120. 三角形最小路径和
 * https://leetcode.cn/leetbook/read/path-problems-in-dynamic-programming/rtfiiv/
 * 
 * @author hwxy
 * @date 2022/07/10
 **/
public class Lc120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        // (0,0)到(i,j)的最小和,dp[i][j]=g[i][j]+min(dp[i-1][j],dp[i-1][j-1]),有可能有空数据要判断
        // 最后返回 min(dp[n-1][j])
        // 可以使用滚动数组优化,因为只是用了上一行的数据,使用对2求模%2或对1求与&1进行寻址
        int[][] dp = new int[2][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            for (int j = 0; j < i + 1; j++) {
                // 第一列只能由(i-1,j)获取,最后一列只能由(i-1,j-1)获取
                int x = i & 1;
                int preX = (i - 1) & 1;
                dp[x][j] = Integer.MAX_VALUE;
                if (j != 0) {
                    dp[x][j] = Math.min(dp[x][j], dp[preX][j - 1]);
                }
                if (j != i) {
                    dp[x][j] = Math.min(dp[x][j], dp[preX][j]);
                }
                dp[x][j] += triangle.get(i).get(j);
            }
        }
        int ans = Integer.MAX_VALUE;
        int lastX = (triangle.size() - 1) & 1;
        for (int j = 0; j < triangle.size(); j++) {
            ans = Math.min(ans, dp[lastX][j]);
        }
        return ans;
    }
}

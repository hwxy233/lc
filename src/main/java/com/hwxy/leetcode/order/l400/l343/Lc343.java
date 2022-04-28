package com.hwxy.leetcode.order.l400.l343;

/**
 * 343. 整数拆分
 * https://leetcode-cn.com/problems/integer-break/
 * 
 * @author hwxy
 * @date 2022/04/28
 **/
public class Lc343 {
    /**
     * dp
     * 1. dp[i]拆分i的乘积的最大值
     * 2. dp[i] = max{dp[i], (i-j) * j, j * dp[i-j]}
     * (i-j) * j意思是拆成2个数的乘积
     * j * dp[i-j]为拆成多个数的乘积(因为dp[i-j]代表着i-j的这个数的乘积最大值了一定是拆成了至少2个数)
     * 3. dp[0]和dp[1]没有意义, dp[2]=1, i应当从3开始
     * 4. 顺序遍历
     *
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[(i - j)]));
            }
        }
        return dp[n];
    }
}

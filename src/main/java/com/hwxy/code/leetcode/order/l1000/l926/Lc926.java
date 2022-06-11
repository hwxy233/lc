package com.hwxy.code.leetcode.order.l1000.l926;

/**
 * 926. 将字符串翻转到单调递增
 * https://leetcode.cn/problems/flip-string-to-monotone-increasing/
 * 
 * @author hwxy
 * @date 2022/06/11
 **/
public class Lc926 {
    public static final char C_ZERO = '0';
    public static final char C_ONE = '1';

    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 如果字符s0到i-1是单调的,则翻转/不翻转i的位置后也会保持单调
        // dp[i][0]和dp[i][1]表示让i位置字符是0或1的最小翻转次数
        // 0的话要求前面也得是0
        // dp[i][0] = dp[i-1][0] + s[i] == 1 ? 1 : 0
        // 1的话前面可以是0/1,所以取最小值
        // dp[i][1] = min(dp[i-1][0],dp[i-1][1]) + s[i] == 0 ? 1 : 0
        char[] scs = s.toCharArray();
        int[][] dp = new int[scs.length][2];
        // 初始值
        dp[0][0] = scs[0] == C_ONE ? 1 : 0;
        dp[0][1] = scs[0] == C_ZERO ? 1 : 0;
        for (int i = 1; i < scs.length; i++) {
            dp[i][0] = dp[i - 1][0] + (scs[i] == C_ONE ? 1 : 0);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + (scs[i] == C_ZERO ? 1 : 0);
        }
        return Math.min(dp[dp.length - 1][0], dp[dp.length - 1][1]);
    }
}

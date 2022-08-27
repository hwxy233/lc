package com.hwxy.code.leetcode.order.l1500.l1422;

/**
 * 1422. 分割字符串的最大得分
 * https://leetcode.cn/problems/maximum-score-after-splitting-a-string/
 * 
 * @author hwxy
 * @date 2022/08/14
 **/
public class Lc1422 {
    public static final char C_ZERO = '0';

    public int maxScore(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        // 统计到index的0的数量和1的数量,前缀和
        int[] zeroCnt = new int[s.length()];
        int zeros = 0;
        int[] oneCnt = new int[s.length()];
        int ones = 0;
        char[] scs = s.toCharArray();
        for (int i = 0; i < scs.length; i++) {
            if (scs[i] == C_ZERO) {
                zeros++;
            } else {
                ones++;
            }
            zeroCnt[i] = zeros;
            oneCnt[i] = ones;
        }
        // 统计出最大值
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            ans = Math.max(ans, zeroCnt[i] + oneCnt[s.length() - 1] - oneCnt[i]);
        }
        return ans;
    }
}

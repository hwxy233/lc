package com.hwxy.code.leetcode.order.l1200.l1143;

/**
 * 1143. 最长公共子序列
 * https://leetcode.cn/problems/longest-common-subsequence/
 * 
 * @author hwxy
 * @date 2022/06/27
 **/
public class Lc1143 {
    public static final String SPACE = " ";

    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.isEmpty() || text2 == null || text2.isEmpty()) {
            return 0;
        }
        // dp[i][j]代表text1的前i个字符中和text2的前j个字符中的最长公共子串
        text1 = SPACE + text1;
        text2 = SPACE + text2;
        int[][] dp = new int[text1.length()][text2.length()];
        // 追加一个空格后就有了初始值第一行第一列为1(因为有了相同的" ")
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }
        char[] t1cs = text1.toCharArray();
        char[] t2cs = text2.toCharArray();
        // 如果当前字符相等则=前一个+1,否则取前面的最大值
        for (int i = 1; i < t1cs.length; i++) {
            for (int j = 1; j < t2cs.length; j++) {
                if (t1cs[i] == t2cs[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // 最终最后位置-1就是答案
        return dp[t1cs.length - 1][t2cs.length - 1] - 1;
    }
}

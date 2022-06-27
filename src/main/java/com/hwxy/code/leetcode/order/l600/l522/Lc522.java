package com.hwxy.code.leetcode.order.l600.l522;

import java.util.Arrays;

/**
 * 522. 最长特殊序列 II
 * https://leetcode.cn/problems/longest-uncommon-subsequence-ii/
 * 
 * @author hwxy
 * @date 2022/06/27
 **/
public class Lc522 {
    public static final String SPACE = " ";

    public int findLUSlength(String[] strs) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        // 公共子串问题
        int ans = -1;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= ans) {
                continue;
            }
            boolean ok = true;
            for (int j = 0; ok && j < strs.length; j++) {
                if (i == j) {
                    continue;
                }
                // 只要i是j的子串则不是答案
                if (check(strs[i], strs[j])) {
                    ok = false;
                }
            }
            if (ok) {
                ans = strs[i].length();
            }
        }
        return ans;
    }

    private boolean check(String text1, String text2) {
        if (text1.length() > text2.length()) {
            return false;
        }
        char[] t1cs = (SPACE + text1).toCharArray();
        char[] t2cs = (SPACE + text2).toCharArray();
        int[][] dp = new int[t1cs.length][t2cs.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < t1cs.length; i++) {
            for (int j = 1; j < t2cs.length; j++) {
                if (t1cs[i] == t2cs[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                if (dp[i][j] == t1cs.length) {
                    return true;
                }
            }
        }
        return false;
    }
}

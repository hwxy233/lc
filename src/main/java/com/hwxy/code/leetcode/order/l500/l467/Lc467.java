package com.hwxy.code.leetcode.order.l500.l467;

import java.util.Arrays;

/**
 * 467. 环绕字符串中唯一的子字符串
 * https://leetcode.cn/problems/unique-substrings-in-wraparound-string/
 * 
 * @author hwxy
 * @date 2022/05/25
 **/
public class Lc467 {
    /**
     * 子串问题优先考虑dp[i]以第i个字母结尾的dp,或者是滑动窗口
     * backtracking会超时
     * 
     * @param p
     * @return
     */
    public int findSubstringInWraproundString(String p) {
        if (p == null || p.length() == 0) {
            return 0;
        }
        char[] cs = p.toCharArray();
        // dp[i]为第i个字母结尾的最长子串长度
        // dp[cs[i]-'a'] = cs[i] - cs[i-1] == 1 ? Math.max(dp[cs[i] - 'a'], length) : 1
        // dp[cs[0]-'a'] = 1
        int[] dp = new int[26];
        dp[cs[0] - 'a'] = 1;
        int length = 1;
        for (int i = 1; i < cs.length; i++) {
            // 差值加一圈再模就不会有负数了
            if ((cs[i] - cs[i - 1] + 26) % 26 == 1) {
                length++;
            } else {
                length = 1;
            }
            dp[cs[i] - 'a'] = Math.max(dp[cs[i] - 'a'], length);
        }
        return Arrays.stream(dp).sum();
    }

}

package com.hwxy.code.leetcode.order.l800.l730;

/**
 * 730. 统计不同回文子序列
 * https://leetcode.cn/problems/count-different-palindromic-subsequences/submissions/
 * 
 * @author hwxy
 * @date 2022/06/10
 **/
public class Lc730 {

    public static final char A = 'a';

    public static final int MOD = (int) (Math.pow(10, 9) + 7);
    /**
     * 只会出现这些字符
     */
    public static final char[] CS = new char[] {A, 'b', 'c', 'd'};

    public int countPalindromicSubsequences(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        // dp[x][i][j]表示以字符x开头下标i到j的回文串的长度,根据i和j位置的字符是否相等有4中情况
        int[][][] dp = new int[4][s.length()][s.length()];
        char[] cs = s.toCharArray();
        // 初始值x的i开始i结束的会问长度是1
        for (int i = 0; i < cs.length; i++) {
            dp[cs[i] - A][i][i] = 1;
        }
        // 开始计算从(0,0)到(0,length-1)的情况
        for (int len = 2; len <= cs.length; len++) {
            for (int i = 0; i + len <= cs.length; i++) {
                int j = i + len - 1;
                for (char c : CS) {
                    // 1. 如果i和j位置的字符是c
                    if (cs[i] == c && cs[j] == c) {
                        // 那么i+1,j-1位置的回文串在首尾都加上x还是回文串,并且会新增加x和xx2个回文串
                        for (char cd : CS) {
                            dp[c - A][i][j] = (dp[c - A][i][j] + dp[cd - A][i + 1][j - 1]) % MOD;
                        }
                        dp[c - A][i][j] = (dp[c - A][i][j] + 2) % MOD;
                    } else if (cs[j] == c) {
                        // 2. j是c,那么就等于i+1到j的回文串数量
                        dp[c - A][i][j] = dp[c - A][i + 1][j];
                    } else if (cs[i] == c) {
                        // 3. i是c,那么就等于i到j-1的回文串数量
                        dp[c - A][i][j] = dp[c - A][i][j - 1];
                    } else {
                        // 4. 都不是,那就i+1到j-1
                        dp[c - A][i][j] = dp[c - A][i + 1][j - 1];
                    }
                }
            }
        }
        // 最后结果就是4个0,length-1的和再求MOD
        int ans = 0;
        for (char c : CS) {
            ans = (ans + dp[c - A][0][cs.length - 1]) % MOD;
        }
        return ans;
    }


}

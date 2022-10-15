package com.hwxy.code.leetcode.order.l1000.l940;

/**
 * 940. 不同的子序列 II
 * https://leetcode.cn/problems/distinct-subsequences-ii/
 *
 * @author hwxy
 * @date 2022/10/14
 **/
public class Lc940 {
    int MOD = (int) 1e9 + 7;

    public int distinctSubseqII(String s) {
        int n = s.length(), ans = 0;
        // f[i][j]为前i长度以j字符结尾的长度
        int[][] f = new int[n + 1][26];
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            for (int j = 0; j < 26; j++) {
                // 如果当前位置的字符和j不相同,也就是不以j结尾,那么f[i][j] = f[i-1][j]
                if (c != j) {
                    f[i][j] = f[i - 1][j];
                } else {
                    int cur = 1;
                    // 如果当前位置的字符和j相同,也就是以j结尾,那么f[i][j] = 所有的f[i-1][j]和+1
                    for (int k = 0; k < 26; k++) {
                        cur = (cur + f[i - 1][k]) % MOD;
                    }
                    f[i][j] = cur;
                }
            }
        }
        // 答案就是前n长度的全部字符情况的和
        for (int i = 0; i < 26; i++) {
            ans = (ans + f[n][i]) % MOD;
        }
        return ans;
    }
}

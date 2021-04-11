package com.hwxy.other.base.dynamic;

/**
 * 最长公共子序列问题
 *
 * @author hwxy
 * @date 2021/04/11
 **/
public class LscQuestion {
    public static void main(String[] args) {
        System.out.println(calLcs(4, 4, "abcd", "becd"));
    }

    /**
     * Si与Tj的最长公共子序列的长度
     */
    private static int[][] DP;
    /**
     * s的长
     */
    public static int SN;
    /**
     * t的长
     */
    public static int TM;

    /**
     * 求s和t的最长公共子序列
     *
     * @param n s的长度
     * @param m t的长度
     * @param s s
     * @param t t
     * @return 公共的最长长度
     */
    public static int calLcs(int n, int m, String s, String t) {
        SN = n;
        TM = m;
        DP = new int[SN + 1][TM + 1];
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                DP[i][j] = 0;
            }
        }
        for (int i = 0; i < SN; i++) {
            for (int j = 0; j < TM; j++) {
                // 如果Si和Tj的字符相等了说明Si+1和Tj+1的长度=Si与Tj的最大公共子序列+1
                if (s.charAt(i) == t.charAt(j)) {
                    DP[i + 1][j + 1] = DP[i][j] + 1;
                } else {
                    DP[i + 1][j + 1] = Math.max(DP[i + 1][j], DP[i][j + 1]);
                }
            }
        }
        return DP[SN][TM];
    }
}

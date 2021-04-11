package com.hwxy.other.base.dynamic;

/**
 * 完全背包问题
 *
 * @author hwxy
 * @date 2021/04/11
 **/
public class AllBagQuestion {
    public static void main(String[] args) {
//        System.out.println(calMaxValue(3, new int[]{3, 4, 2}, new int[]{4, 5, 3}, 7));
        System.out.println(calMaxValue1(3, new int[]{3, 4, 2}, new int[]{4, 5, 3}, 7));
    }

    /**
     * 物品数
     */
    public static int N;
    /**
     * 重量
     */
    public static int[] W;
    /**
     * 物品价值
     */
    public static int[] V;
    /**
     * 重量限制
     */
    public static int WI;
    /**
     * 从前i种物品中选出重量不超过j的最大价值
     */
    public static int[][] DP;

    public static int calMaxValue(int n, int[] w, int[] v, int wi) {
        N = n;
        W = w;
        V = v;
        WI = wi;
        DP = new int[N + 1][WI + 1];
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                DP[i][j] = 0;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= WI; j++) {
                // DP[i+1][j] = max(dp[i][j], max{dp[i+1][j-k*W[i]] + k*V[i]})
                for (int k = 0; j - k * W[i] >= 0; k++) {
                    DP[i + 1][j] = Math.max(DP[i + 1][j], DP[i][j - k * W[i]] + k * V[i]);
                }
            }
        }
        return DP[N][WI];
    }

    /**
     * 去掉k的循环
     *
     * @param n
     * @param w
     * @param v
     * @param wi
     * @return
     */
    public static int calMaxValue1(int n, int[] w, int[] v, int wi) {
        N = n;
        W = w;
        V = v;
        WI = wi;
        DP = new int[N + 1][WI + 1];
        for (int i = 0; i < DP.length; i++) {
            for (int j = 0; j < DP[0].length; j++) {
                DP[i][j] = 0;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= WI; j++) {
                // 重量超了
                if (W[i] > j) {
                    DP[i + 1][j] = DP[i][j];
                } else {
                    // 由递推公式反推出来的,注意是i+1
                    DP[i + 1][j] = Math.max(DP[i][j], DP[i + 1][j - W[i]] + V[i]);
                }
            }
        }
        return DP[N][WI];
    }
}

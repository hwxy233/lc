package com.hwxy.other.base.dynamic;

/**
 * 多重部分和问题
 *
 * @author hwxy
 * @date 2021/04/17
 **/
public class PartSum {
    public static void main(String[] args) {
//        System.out.println(solvePartSum(3, new int[]{3, 5, 8}, new int[]{3, 2, 2}, 17));
        System.out.println(solvePartSum2(3, new int[]{3, 5, 8}, new int[]{3, 2, 2}, 17));
    }

    /**
     * n个数ai，各mi个，是否可以选出若干个
     * 让和为k
     *
     * @param n
     * @param a
     * @param m
     * @param kSum
     * @return
     */
    public static boolean solvePartSum(int n, int[] a, int[] m, int kSum) {
        // dp[i+1][j] = 在前i个数的和是否能是j
        boolean[][] dp = new boolean[n + 1][kSum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = false;
            }
        }
        // 和是0肯定可以
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= kSum; j++) {
                // dp[i+1][j] = (0<=k<=mi && k*ai<=j 可以使dp[i][ji-ai*k]为true)
                for (int k = 0; k <= m[i] && k * a[i] <= j; k++) {
                    boolean c = dp[i + 1][j];
                    // 存在k循环所以每次要保留上次的结果防止被false替换
                    dp[i + 1][j] = dp[i + 1][j] || dp[i][j - k * a[i]];
                }
            }
        }
        return dp[n][kSum];
    }

    /**
     * n个数ai，各mi个，是否可以选出若干个
     * 让和为k
     * 可以简化k的循环的情况
     *
     * @param n
     * @param a
     * @param m
     * @param kSum
     * @return
     */
    public static boolean solvePartSum2(int n, int[] a, int[] m, int kSum) {
        // dp[i+1][j] = 在前i个数的和是j时,剩余的i的最大个数,如果加不到j就是-1
        int[][] dp = new int[n + 1][kSum + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        // 分这么三种情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= kSum; j++) {
                // 1.如果[i][j] >=0 就说明前i种一定满足和为j了,这是i物品要么全用了要么剩一些,这时已经无关紧要
                if (dp[i][j] >= 0) {
                    // 前i种满足j,i+1种就1个都用不掉了
                    dp[i + 1][j] = m[i];
                }
                // 2.如果ai的比剩余的j大了那肯定没戏了,或者mi都用了也不够j的话...ps:<=0 写成 <1 更合理
                else if (j < a[i] || dp[i + 1][j - a[i]] <= 0) {
                    dp[i + 1][j] = -1;
                }
                // 3.好了,通常情况,如果用a[i]能加出j-a[i]的和的话，那满足和j时剩余的个数就是满足和j-a[i]时的数量-1
                else {
                    dp[i + 1][j] = dp[i + 1][j - a[i]] - 1;
                }
            }
        }
        // 只要最后剩的数量>=0 ...反正不是-1就说明可以凑够j
        return dp[n][kSum] >= 0;
    }
}

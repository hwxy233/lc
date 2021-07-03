package com.hwxy.OJ.base.greedy;

/**
 * 硬币问题
 *
 * @author hwxy
 * @date 2021/03/27
 **/
public class CoinQuestion {

    private static int[] COIN_VALUE = new int[]{1, 5, 10, 50, 100, 500};

    public static void main(String[] args) {
        System.out.println(calCoins(3, 2, 1, 3, 0, 2, 620));
    }

    /**
     * 计算凑够金额的最少硬币数
     *
     * @param c1   1价值的数量
     * @param c5
     * @param c10
     * @param c50
     * @param c100
     * @param c500
     * @param a    所需金额
     * @return 最少硬币数
     */
    public static int calCoins(int c1, int c5, int c10, int c50, int c100, int c500, int a) {
        int[] coinNumber = new int[]{c1, c5, c10, c50, c100, c500};
        int count = 0;
        for (int i = COIN_VALUE.length - 1; i >= 0; i--) {
            int used = Math.min(a / COIN_VALUE[i], coinNumber[i]);
            a -= used * COIN_VALUE[i];
            count += used;
        }
        return count;
    }
}

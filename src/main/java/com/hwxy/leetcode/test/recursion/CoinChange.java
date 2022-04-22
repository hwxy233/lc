package com.hwxy.leetcode.test.recursion;

/**
 * 凑零钱问题
 */
public class CoinChange {
    public static void main(String[] args) {
//        System.out.println(coinChange(new int[]{1, 3, 5}, 11));
        System.out.println(coinChangeDp(new int[]{3, 5}, 11));
        System.out.println(coinChangeDp(new int[]{1, 3, 5}, 11));
    }

    /**
     * 凑零钱问题-dp
     *
     * @param coins  硬币的面值
     * @param amount 要凑出的金额
     * @return 最少的硬币数量
     */
    static int coinChangeDp(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 对于金额i,dpTable[i]为所需要的最少硬币数量
        int[] dpTable = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            // 当coin均使用1时,最大值为amount+1,如果是Integer.MAX会溢出
            dpTable[i] = amount + 1;
            for (int coin : coins) {
                int am = i - coin;
                // 凑不出来
                if (am < 0) {
                    continue;
                }
                // 比较当前的数量和减掉coin后金额所需硬币数+1的大小
                dpTable[i] = Math.min(dpTable[i], dpTable[am] + 1);
            }
        }
        // 需要的是amount的
        if (dpTable[amount] == amount + 1 || dpTable[amount] < 0) {
            return -1;
        }
        return dpTable[amount];
    }


    /**
     * 凑零钱问题
     *
     * @param coins  硬币的面值
     * @param amount 要凑出的金额
     * @return 最少的硬币数量
     */
    static int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int[] cache = new int[amount + 1];
        return doCoinChange(coins, amount, cache);
    }

    private static int doCoinChange(int[] coins, int amount, int[] cache) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 设为最大值,下面每次取小的
        int minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            amount = amount - coin;
            if (amount < 0) {
                return -1;
            }
            // 这里用缓存来换取时间
            int result = cache[amount];
            if (result == 0) {
                // min{dp(amount-coin) + 1},减去金额的话使用的硬币数量就要+1,取所有的减掉第一个硬币后所用数量最少的
                result = coinChange(coins, amount) + 1;
                cache[amount] = result;
            }
            // 抹掉0和-1的情况
            if (result > 0) {
                minCoins = Math.min(minCoins, result);
            }
        }
        // 凑不出的情况下要处理为-1
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

}

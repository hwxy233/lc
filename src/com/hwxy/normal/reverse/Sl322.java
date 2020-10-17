package com.hwxy.normal.reverse;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 *
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sl322 {
    public static void main(String[] args) {
        Sl322 sl322 = new Sl322();
//        System.out.println(sl322.coinChange(new int[]{186, 419, 83, 408}, 6249));
        System.out.println(sl322.coinChange(new int[]{2}, 3));
    }

    /**
     * 凑零钱问题-dp
     *
     * @param coins  硬币的面值
     * @param amount 要凑出的金额
     * @return 最少的硬币数量
     */
    public int coinChange(int[] coins, int amount) {
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
}

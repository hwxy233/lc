package com.hwxy.code.leetcode.order.l1300.l1217;

/**
 * 1217. 玩筹码
 * https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 * 
 * @author hwxy
 * @date 2022/07/08
 **/
public class Lc1217 {
    public int minCostToMoveChips(int[] position) {
        if (position == null || position.length < 2) {
            return 0;
        }
        // 其实就是奇数位置移动到同一个奇数位置,偶数都移动到一个偶数位置
        // 然后少的那一个都要移动到多的那一个
        int odd = 0;
        int even = 0;
        for (int p : position) {
            if (p % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}

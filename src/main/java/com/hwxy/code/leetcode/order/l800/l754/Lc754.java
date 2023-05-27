package com.hwxy.code.leetcode.order.l800.l754;

/**
 * 754. 到达终点数字
 * https://leetcode.cn/problems/reach-a-number/
 *
 * @author hwxy
 * @date 2022/11/04
 **/
public class Lc754 {
    public int reachNumber(int target) {
        if (target == 0) {
            return -1;
        }
        int normal = 1 + (target - 1) * 2;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            int res = (1 + i) * i;
            if (res == target * 2) {
                return Math.min(i, normal);
            } else if (res > target * 2) {
                break;
            }
        }
        return normal;
    }
}

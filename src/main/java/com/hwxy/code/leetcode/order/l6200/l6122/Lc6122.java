package com.hwxy.code.leetcode.order.l6200.l6122;

import java.util.Arrays;

/**
 * 6122. 使数组可以被整除的最少删除次数
 * https://leetcode.cn/problems/minimum-deletions-to-make-array-divisible/
 *
 * @author hwxy
 * @date 2022/07/17
 **/
public class Lc6122 {
    public int minOperations(int[] nums, int[] numsDivide) {
        if (nums == null || numsDivide == null) {
            return -1;
        }
        // 求出numsDivide里面的最大公约数
        int maxFan = numsDivide[0];
        for (int i = 1; i < numsDivide.length; i++) {
            maxFan = gcd(maxFan, numsDivide[i]);
        }
        // 然后从nums里找最小的能整除最大公约数的
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (maxFan % nums[i] == 0) {
                // 返回删除的数量也就是i的下标
                return i;
            }
        }
        return -1;
    }

    /**
     * 求最大公约数
     * a / b = q...r
     * (a, b) = (b, r)
     * 当b==0时公约数就是a
     */
    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}

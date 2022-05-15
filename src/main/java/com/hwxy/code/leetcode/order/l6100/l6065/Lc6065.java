package com.hwxy.code.leetcode.order.l6100.l6065;

/**
 * 6065. 按位与结果大于零的最长组合
 * https://leetcode.cn/contest/weekly-contest-293/problems/largest-combination-with-bitwise-and-greater-than-zero/
 * 
 * @author hwxy
 * @date 2022/05/15
 **/
public class Lc6065 {

    public int largestCombination(int[] candidates) {
        // 最长32位
        int[] cnt = new int[32];
        int max = 0;
        // 只有某一位都是1相与的结果才不是0,所以找到同一位是1的最多的数就是结果
        for (int c : candidates) {
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & c) > 0) {
                    cnt[i]++;
                }
            }
        }
        for (int i = 0; i < 32; i++) {
            max = Math.max(max, cnt[i]);
        }
        return max;
    }

}

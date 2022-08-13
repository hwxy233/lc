package com.hwxy.code.leetcode.order.l1500.l1413;

/**
 * 1413. 逐步求和得到正数的最小值
 * https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 * 
 * @author hwxy
 * @date 2022/08/09
 **/
public class Lc1413 {

    public int minStartValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        // 计算前缀和的最小值,最后如果最小值>=0返回1否则返回绝对值+1
        return min >= 0 ? 1 : -min + 1;
    }
}

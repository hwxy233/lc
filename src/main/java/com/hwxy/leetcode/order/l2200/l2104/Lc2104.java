package com.hwxy.leetcode.order.l2200.l2104;

/**
 * 2104. 子数组范围和
 * https://leetcode-cn.com/problems/sum-of-subarray-ranges/
 * 
 * @author hwxy
 * @date 2022/03/04
 **/
public class Lc2104 {
    public long subArrayRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = nums[i];
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }
}

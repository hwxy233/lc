package com.hwxy.leetcode.order.l1000.l908;

import java.util.Arrays;

/**
 * 908. 最小差值 I
 * https://leetcode-cn.com/problems/smallest-range-i/
 * 
 * @author hwxy
 * @date 2022/04/30
 **/
public class Lc908 {
    public int smallestRangeI(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        // 排序后找到最大值和最小值,然后从最大值逐步减少到k;从最小值逐步增加k
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        for (int i = 0; i < k && max > min; i++) {
            max--;
        }
        for (int i = 0; i < k && min < max; i++) {
            min++;
        }
        return max - min;
    }
}

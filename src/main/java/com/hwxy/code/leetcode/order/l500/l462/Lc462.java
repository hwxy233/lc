package com.hwxy.code.leetcode.order.l500.l462;

import java.util.Arrays;

/**
 * 462. 最少移动次数使数组元素相等 II
 * https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/
 * 
 * @author hwxy
 * @date 2022/05/19
 **/
public class Lc462 {
    /**
     * 在数轴上,只有所有数到中心点的距离才能最短
     * 所以排序后直接求和中心点的差的和
     * 
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        for (int num : nums) {
            ans += Math.abs(num - mid);
        }
        return ans;
    }
}

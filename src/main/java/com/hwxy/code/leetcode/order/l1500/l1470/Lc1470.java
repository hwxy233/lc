package com.hwxy.code.leetcode.order.l1500.l1470;

/**
 * 1470. 重新排列数组
 *
 * <p>https://leetcode.cn/problems/shuffle-the-array/
 *
 * @author hwxy
 * @date 2022/08/29
 */
public class Lc1470 {
    public int[] shuffle(int[] nums, int n) {
        if (nums == null) {
            return null;
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[i * 2] = nums[i];
            ans[i * 2 + 1] = nums[i + n];
        }
        return ans;
    }
}

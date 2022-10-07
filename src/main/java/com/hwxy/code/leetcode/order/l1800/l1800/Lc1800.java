package com.hwxy.code.leetcode.order.l1800.l1800;

/**
 * 1800. 最大升序子数组和
 * https://leetcode.cn/problems/maximum-ascending-subarray-sum/
 *
 * @author hwxy
 * @date 2022/10/07
 **/
public class Lc1800 {
    public int maxAscendingSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += nums[i];
            if (nums[i] >= nums[i + 1]) {
                ans = Math.max(sum, ans);
                sum = 0;
            }
        }
        // 处理最后一个元素
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            sum += nums[nums.length - 1];
            ans = Math.max(sum, ans);
        } else {
            ans = Math.max(Math.max(sum, ans), nums[nums.length - 1]);
        }
        return ans;
    }
}

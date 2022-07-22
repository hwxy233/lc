package com.hwxy.code.leetcode.order.l100.l53;

/**
 * 53. 最大子数组和
 * https://leetcode.cn/problems/maximum-subarray/
 * 
 * @author hwxy
 * @date 2022/07/22
 **/
public class Lc53 {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // return fun1(nums);
        return fun2(nums);
    }

    /**
     * 动态规划
     * 
     * @param nums
     * @return
     */
    private int fun2(int[] nums) {
        // dp[i]为以i结尾的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 如果前一个和是小于0的则重新开始计算
            dp[i] = dp[i - 1] >= 0 ? dp[i - 1] + nums[i] : nums[i];
            ans = Math.max(ans, dp[i]);
        }
        // 最后应该重新遍历一遍返回最大值
        return ans;
    }

    /**
     * 滑动窗口
     * 
     * @param nums
     * @return
     */
    private int fun1(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int window = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            window += nums[right];
            ans = Math.max(window, ans);
            while (window < 0) {
                int pop = nums[left];
                window -= pop;
                left++;
            }
            right++;
        }
        return ans;
    }
}

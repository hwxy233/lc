package com.hwxy.leetcode.order.l2100.l2044;

/**
 * 2044. 统计按位或能得到最大值的子集数目
 * https://leetcode-cn.com/problems/count-number-of-maximum-bitwise-or-subsets/
 * 
 * @author hwxy
 * @date 2022/03/17
 **/
public class Lc2044 {
    /**
     * 最终结果的次数
     */
    private int cnt;
    /**
     * 当前子集的sum
     */
    private int curSum;
    /**
     * 全局的最大sum
     */
    private int maxSum;

    public int countMaxOrSubsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        cnt = 0;
        curSum = Integer.MIN_VALUE;
        maxSum = Integer.MIN_VALUE;
        backtracking(nums, 0);
        return cnt;
    }

    private void backtracking(int[] nums, int index) {
        for (int i = index; i < nums.length; i++) {
            // 记录这次子集的计算前的sum
            int preSum = curSum;
            if (preSum == Integer.MIN_VALUE) {
                curSum = nums[i];
            } else {
                curSum = curSum | nums[i];;
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                cnt = 1;
            } else if (curSum == maxSum) {
                cnt++;
            }
            backtracking(nums, i + 1);
            // 进行撤销
            curSum = preSum;
        }
    }
}

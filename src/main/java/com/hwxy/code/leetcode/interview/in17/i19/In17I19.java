package com.hwxy.code.leetcode.interview.in17.i19;

import java.util.Arrays;

/**
 * 面试题 17.19. 消失的两个数字
 * https://leetcode.cn/problems/missing-two-lcci/
 *
 * @author hwxy
 * @date 2022/09/26
 **/
public class In17I19 {
    public int[] missingTwo(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        // 求出1到n的和,然后和实际缺少数`nums`的和相减
        // 差值就是缺的2个数的平均值(一定是一个在平均值左一个在右)
        int sum = (1 + nums.length + 2) * (nums.length + 2) / 2;
        int curSum = Arrays.stream(nums).sum();
        int diff = sum - curSum;
        // 再计算1到mid的和与`nums`中所有`<=mid`相减,这就得到了缺的第一个数
        int mid = diff / 2;
        int midSum = (1 + mid) * mid / 2;
        int curMidSum = Arrays.stream(nums).filter(i -> i <= mid).sum();
        int first = midSum - curMidSum;
        // 然后用差值与第一个数相减就是第二个数
        int second = diff - first;
        return new int[] {first, second};
    }
}

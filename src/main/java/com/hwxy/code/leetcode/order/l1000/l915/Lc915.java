package com.hwxy.code.leetcode.order.l1000.l915;

/**
 * 915. 分割数组
 * https://leetcode.cn/problems/partition-array-into-disjoint-intervals/
 *
 * @author hwxy
 * @date 2022/10/24
 **/
public class Lc915 {
    public int partitionDisjoint(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 1. 找到第一个出现的最小值的位置
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                minIndex = i;
                min = nums[i];
            }
        }
        // 2. 找到[0,minIndex]的最大值
        int leftMax = min;
        for (int i = 0; i < minIndex; i++) {
            leftMax = Math.max(leftMax, nums[i]);
        }
        // 3. 从(minIndex,end]找比leftMax小的更新分割点
        int breakIndex = minIndex;
        int midMax = leftMax;
        for (int i = minIndex + 1; i < nums.length; i++) {
            // 注意会产生中间更大的情况,(42,0,62,16,46,75...)
            // 62就是中间更大值要记录,在更新分割点的时候更新
            if (nums[i] < leftMax) {
                breakIndex = i;
                leftMax = midMax;
            } else {
                midMax = nums[i];
            }
        }
        return breakIndex + 1;
    }
}

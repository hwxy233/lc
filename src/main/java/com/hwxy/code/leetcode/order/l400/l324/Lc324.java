package com.hwxy.code.leetcode.order.l400.l324;

import java.util.Arrays;

/**
 * 324. 摆动排序 II
 * https://leetcode.cn/problems/wiggle-sort-ii/
 * 
 * @author hwxy
 * @date 2022/06/28
 **/
public class Lc324 {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);
        boolean leftMore = newNums.length % 2 != 0;
        int half = newNums.length / 2;
        int left = leftMore ? half : half - 1;
        int right = newNums.length - 1;
        int index = 0;
        int end = left;
        while (right > end) {
            nums[index++] = newNums[left--];
            nums[index++] = newNums[right--];
        }
        if (leftMore) {
            nums[nums.length - 1] = newNums[0];
        }
    }
}

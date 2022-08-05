package com.hwxy.code.leetcode.order.l6200.l6132;

import java.util.Arrays;

/**
 * 6132. 使数组中所有元素都等于零
 * https://leetcode.cn/contest/weekly-contest-304/problems/make-array-zero-by-subtracting-equal-amounts/
 * 
 * @author hwxy
 * @date 2022/07/31
 **/
public class Lc6132 {
    public int minimumOperations(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 其实只要统计不同的非0数的数量就行了
        if (nums.length == 1) {
            return nums[0] == 0 ? 0 : 1;
        }
        Arrays.sort(nums);
        int ans = 0;
        int lastZero = 0;
        while (lastZero != nums.length - 1) {
            int minIndex = findMin(nums, lastZero);
            if (minIndex == -1) {
                return ans;
            }
            lastZero = countDown(nums, lastZero, nums[minIndex]);
            ans++;
        }
        return ans;
    }

    private int countDown(int[] nums, int lastZero, int min) {
        for (int i = lastZero; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[i] -= min;
                if (nums[i] == 0) {
                    lastZero = i;
                }
            }
        }
        return lastZero;
    }

    private int findMin(int[] nums, int lastZero) {
        for (int i = lastZero; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return -1;
    }
}

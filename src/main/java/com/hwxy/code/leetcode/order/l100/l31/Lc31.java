package com.hwxy.code.leetcode.order.l100.l31;

/**
 * 31. 下一个排列
 * https://leetcode.cn/problems/next-permutation/
 * 
 * @author hwxy
 * @date 2022/07/03
 **/
public class Lc31 {

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 先从右向左找到非递增的位置
        int notIncIndex = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                notIncIndex = i - 1;
                break;
            }
        }
        if (notIncIndex == -1) {
            // 全部reverse,说明没有更大的了
            for (int left = 0, right = nums.length - 1; left < right; left++, right--) {
                swap(nums, left, right);
            }
            return;
        }
        // 从nii向右找到>的位置
        for (int i = nums.length - 1; i > notIncIndex; i--) {
            if (nums[i] > nums[notIncIndex]) {
                // swap
                swap(nums, i, notIncIndex);
                // reverse
                for (int left = notIncIndex + 1,
                        right = nums.length - 1; left < right; left++, right--) {
                    swap(nums, left, right);
                }
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int notIncIndex) {
        int tmp = nums[i];
        nums[i] = nums[notIncIndex];
        nums[notIncIndex] = tmp;
    }
}

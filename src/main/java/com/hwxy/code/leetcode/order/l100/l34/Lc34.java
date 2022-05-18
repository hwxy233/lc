package com.hwxy.code.leetcode.order.l100.l34;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * @author hwxy
 * @date 2022/05/18
 **/
public class Lc34 {
    public static final int[] BAD_ANS = new int[] {-1, -1};

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0 || (target < nums[0]
                || target > nums[nums.length - 1])) {
            return BAD_ANS;
        }
        // 2次二分查找(红蓝)
        // 第一次isBlue为<8,返回r
        int l = -1;
        int r = nums.length;
        while (l + 1 != r) {
            int m = (l + r) >> 1;
            if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (nums[r] != target) {
            return BAD_ANS;
        }
        int[] ans = new int[2];
        ans[0] = r;
        // 第二次isBlue为<=8,返回l
        l = -1;
        r = nums.length;
        while (l + 1 != r) {
            int m = (l + r) >> 1;
            if (nums[m] <= target) {
                l = m;
            } else {
                r = m;
            }
        }
        ans[1] = l;
        return ans;
    }
}

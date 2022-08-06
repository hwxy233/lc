package com.hwxy.code.leetcode.order.l100.l33;

/**
 * 干嘛的
 *
 * @author hwxy
 * @date 2022/08/06
 **/
public class Lc33Nc {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // 看看[0,mid]是否是递增区间
            if (nums[0] <= nums[mid]) {
                // 看看target是否在区间里
                if (nums[0] <= target && target <= nums[mid]) {
                    // 在的话就缩小右区间即可
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 说明[mid,length-1]是递增的
                if (nums[mid] <= target && target <= nums[nums.length - 1]) {
                    // 缩小左区间即可
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

}

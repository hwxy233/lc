package com.hwxy.code.leetcode.order.l600.l540;

/**
 * 540. 有序数组中的单一元素
 * https://leetcode-cn.com/problems/single-element-in-a-sorted-array/
 * 
 * @author hwxy
 * @date 2022/02/14
 **/
public class Lc540 {
    public static void main(String[] args) {
        System.out.println(new Lc540().singleNonDuplicate(new int[] {1, 1, 2, 3, 3, 4, 4, 8, 8}));
        System.out.println(new Lc540().singleNonDuplicate(new int[] {3, 3, 7, 7, 10, 11, 11}));
    }

    public int singleNonDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MIN_VALUE;
        }
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 如果mid为偶数,则应当与后一个数相等
            if (mid % 2 == 0) {
                // 说明在右边
                if (mid + 1 < nums.length && nums[mid] == nums[mid + 1]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // mid为奇数,则与前一个数相等
                if (mid - 1 >= 0 && nums[mid] == nums[mid - 1]) {
                    // 说明在右边
                    left = mid + 1;
                } else {
                    // 说明在左边
                    right = mid - 1;
                }
            }
        }
        // 这里要试一下
        return nums[left];
    }
}

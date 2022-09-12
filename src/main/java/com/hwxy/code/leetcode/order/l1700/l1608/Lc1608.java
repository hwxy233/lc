package com.hwxy.code.leetcode.order.l1700.l1608;

import java.util.Arrays;

/**
 * 1608. 特殊数组的特征值
 *
 * <p>https://leetcode.cn/problems/special-array-with-x-elements-greater-than-or-equal-x/
 *
 * @author hwxy
 * @date 2022/09/12
 */
public class Lc1608 {
    public int specialArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        Arrays.sort(nums);
        // 排序完二分即可
        for (int i = 1; i <= nums.length; i++) {
            int l = -1;
            int r = nums.length;
            while (l + 1 != r) {
                int mid = (l + r) >> 1;
                if (isBlue(nums, mid, i)) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            if (nums.length - 1 - r + 1 == i) {
                return i;
            }
        }
        return -1;
    }

    private boolean isBlue(int[] nums, int mid, int x) {
        return nums[mid] < x;
    }
}

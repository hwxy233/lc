package com.hwxy.code.leetcode.order.l800.l719;

import java.util.Arrays;

/**
 * 719. 找出第 K 小的数对距离
 * https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * 
 * @author hwxy
 * @date 2022/06/15
 **/
public class Lc719 {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        // 对值二分然后统计对数,l应该是0-1,r应该是最大差值+1
        int l = -1;
        int r = nums[nums.length - 1] - nums[0] + 1;
        // isBlue为小于等于差值m的对数<k,返回r
        while (l + 1 != r) {
            int m = (l + r) >> 1;
            int cnt = cnt(nums, m);
            if (cnt < k) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    /**
     * 双指针找数量
     * 外层要移动右指针
     * 
     * @param nums
     * @param m
     * @return
     */
    private int cnt(int[] nums, int m) {
        int cnt = 0;
        for (int l = 0, r = 0; r < nums.length; r++) {
            while (l < r && (nums[r] - nums[l] > m)) {
                l++;
            }
            cnt += (r - l);
        }
        return cnt;
    }

}

package com.hwxy.code.leetcode.order.l200.l153;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 
 * @author hwxy
 * @date 2022/05/07
 **/
public class Lc153 {
    /**
     * 二分查找
     * 1. 如果nums[0] < nums[length-1]说明整体有序返回nums[0]
     * 2. 否则是2部分分别升序,需要找到前一半的最后一个位置
     * 3. 找到nums[i] > nums[i+1] && nums[i] > nums[i-1],答案就是nums[i+1]
     * 4. 二分时nums[mid]不断和nums[0]进行比较看是否在正确的区间里来移动left或是right
     * 
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 先检查是否有序
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        // 二分查找一个位置,这个位置是i
        // nums[i] > nums[i+1] && nums[i] > nums[i-1]
        int left = 0;
        int right = nums.length - 1;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            // 虽然mid-1可能越界但是mid+1不会,因为最大值不会是最后一个
            if (nums[mid] > nums[mid + 1] &&
                    (mid == 0 || nums[mid] > nums[mid - 1])) {
                // 最大值在第一个位置 || 大于前一个
                ans = mid + 1;
                break;
            } else {
                // 说明还在正确的区间里
                if (nums[mid] >= nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[ans];
    }
}

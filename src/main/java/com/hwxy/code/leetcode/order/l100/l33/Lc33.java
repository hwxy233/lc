package com.hwxy.code.leetcode.order.l100.l33;

/**
 * 33. 搜索旋转排序数组
 * https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * 
 * @author hwxy
 * @date 2022/05/07
 **/
public class Lc33 {
    /**
     * 二分查找
     * 1. 找到翻转点(并且可以进行比较),前和后分别升序有序
     * 2. 后一个区间进行二分查找
     * 
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int changeIndex = -1;
        // 找翻转点,顺便可以对前一半进行比较
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (i > 0 && nums[i] < nums[i - 1]) {
                changeIndex = i;
                break;
            }
        }
        // 没有翻转还没有找到
        int ans = -1;
        if (changeIndex == -1) {
            return ans;
        }
        // 从changeIndex开始进行二分查找,这里是闭区间的形式
        int left = changeIndex;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                ans = mid;
                break;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return -1;
            }
            if (n == 1) {
                return nums[0] == target ? 0 : -1;
            }
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (nums[mid] == target) {
                    return mid;
                }
                // 有序[0,mid]
                if (nums[0] <= nums[mid]) {
                    // target在区间[0.mid]里
                    if (nums[0] <= target && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        // target不在区间[0.mid]里
                        l = mid + 1;
                    }
                } else {
                    // 无有序[0,mid]
                    if (nums[mid] < target && target <= nums[n - 1]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }

}

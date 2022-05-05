package com.hwxy.code.leetcode.order.l800.l704;

/**
 * 704. 二分查找
 * https://leetcode-cn.com/problems/binary-search/
 *
 * @author hwxy
 * @date 2022/01/30
 **/
public class Lc704 {

    public static void main(String[] args) {
        System.out.println(new Lc704().search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) >> 1;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
